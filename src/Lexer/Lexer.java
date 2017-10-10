package Lexer;

import Lexer.Token.*;
import Lexer.CharStream.*;

import java.io.*;
import java.util.Hashtable;

/**
 * 词法分析程序
 */
public class Lexer {
    public int line = 1;        //对输入行计数---------------------------------
    private char peek = ' ';        //存放下一个输入字符
    private Hashtable words = new Hashtable();
    private Hashtable symbols = new Hashtable();

    /**
     * 添加保留字
     *
     * @param
     */
    void reserve(Word t) {
        words.put(t.lexeme, t);
    }

    public Lexer() {
        //保留字
        reserve(new Word(Tag.KEYWORD, "if"));
        reserve(new Word(Tag.KEYWORD, "else"));
        reserve(new Word(Tag.KEYWORD, "while"));
        reserve(new Word(Tag.KEYWORD, "read"));
        reserve(new Word(Tag.KEYWORD, "write"));
        reserve(new Word(Tag.KEYWORD, "int"));
        reserve(new Word(Tag.KEYWORD, "real"));

        //算数运算符
        symbols.put("+", new Token('+'));
        symbols.put("-", new Token('-'));
        symbols.put("*", new Token('*'));
        symbols.put("/", new Token('/'));
        symbols.put("=", new Token('='));

        //单目符号
        symbols.put(">", new Token('>'));
        symbols.put("<", new Token('<'));
        symbols.put("(", new Token('('));
        symbols.put(")", new Token(')'));
        symbols.put("{", new Token('{'));
        symbols.put("}", new Token('}'));
        symbols.put("[", new Token('['));
        symbols.put("]", new Token(']'));
        symbols.put(";", new Token(';'));
        symbols.put(",", new Token(','));

        //双目符号
        symbols.put(">=", new BinaryOperator(">="));
        symbols.put("<=", new BinaryOperator("<="));
        symbols.put("==", new BinaryOperator("=="));
        symbols.put("<>", new BinaryOperator("<>"));
        symbols.put("[]", new BinaryOperator("[]"));

    }

    /**
     * 扫描输入字符
     *
     * @return 返回一个词法单元
     * @throws IOException
     */
    public Token scan(CharStream charStream, File file) throws IOException {
        //跳过空白
        for (; ; peek = (char) charStream.readChar(file)) {
            if (peek == ' ' || peek == '\t')
                continue;
            else if (peek == '\n')
                line++;
            else break;
        }

        //处理数字常量
        if (Character.isDigit(peek)) {
            int v = 0;
            do {
                v = 10 * v + Character.digit(peek, 10);
                peek = (char) charStream.readChar(file);
            } while (Character.isDigit(peek));

            //整数
            if (peek != '.')
                return new Num(v);

            //浮点数
            peek = (char) charStream.readChar(file);
            int f = 0;
            if (Character.isDigit(peek)) {
                do {
                    f = 10 * f + Character.digit(peek, 10);
                    peek = (char) charStream.readChar(file);
                } while (Character.isDigit(peek));
            }

            Num number = new Num(v);
            Num fraction = new Num(f);
            return new RealNum(number, fraction);
        }
        //处理点号'.'
        if (peek == '.') {
            peek = (char) charStream.readChar(file);
            int f = 0;
            if (Character.isDigit(peek)) {
                do {
                    f = 10 * f + Character.digit(peek, 10);
                    peek = (char) charStream.readChar(file);
                } while (Character.isDigit(peek));
            }

            if (f == 0) {     //单独的点号'.'无法识别
                LexerException.unknownSymbolException(".");
                return null;
            }

            Num number = new Num(0);
            Num fraction = new Num(f);
            return new RealNum(number, fraction);
        }


        //处理保留字和标识符
        if (Character.isLetter(peek)) {
            StringBuffer b = new StringBuffer();        //通过缓冲区实现预读
            do {
                b.append(peek);
                peek = (char) charStream.readChar(file);
            } while (Character.isLetter(peek) || Character.isDigit(peek) || peek == '_');

            String s = b.toString();

            //判断最后一个字符是否为下划线
            char c = s.charAt(s.length() - 1);
            if (c == '_') {
                LexerException.identifierException();
                return null;
            }

            //词法单元为关键字
            Word w = (Word) words.get(s);
            if (w != null)
                return w;

            //词法单元为标识符
            w = new Word(Tag.IDENTIFIER, s);
            words.put(s, w);
            return w;
        }

        //处理下划线
        if (peek == '_') {
            LexerException.identifierException();
            return null;
        }

        //处理'#'
        if (peek == '#') {
            return new Token(Tag.END);
        }

        //当程序运行至此处时，说明遇到了特殊符号
        Token t = (Token) symbols.get(String.valueOf(peek));
        if (t == null) {      //未定义的符号
            LexerException.unknownSymbolException(String.valueOf(peek));
            return null;
        }

        //预读下一个字符
        String s = String.valueOf(peek);
        peek = (char) charStream.readChar(file);
        s += String.valueOf(peek);

        //单行注释
        if (s.equals("//")) {
            int r;
            do {
                r = charStream.readChar(file);
            } while (r != '\n');

            peek = ' ';
            return new Token(Tag.ANNOTATION);
        }

        //多行注释
        if (s.equals("/*")) {
            for (; ; ) {
                peek = (char) charStream.readChar(file);
                if (peek == '*') {
                    //预读下一个字符
                    s = String.valueOf(peek);
                    peek = (char) charStream.readChar(file);
                    s += String.valueOf(peek);

                    if (s.equals("*/")) {
                        peek = ' ';
                        return new Token(Tag.ANNOTATION);
                    }
                    continue;
                }
                continue;
            }
        }

        //判断是否为双目符号
        BinaryOperator b = (BinaryOperator) symbols.get(s);
        if (b != null) {
            peek = ' ';
            return b;
        }
        return t;
    }

}

/*

下一步进行：
（1）ok结束符"#"
（2）文件I／O
（3）ok出错处理、报错信息完善（如行号，如继承某个类，如用try）
（4）ok注释// /*
（5）ok浮点数

 */

/*
总结：
1. char与int
2. 注意，对String来说，=，与compare
3. 异常处理：用try,以及ExceptionHandle继承某个类
4. peek多读以后，会不会"吃掉"一个字符
5. RealNum：对象作为参数时
6. Java读取文件

遇到耗时的地方/设计的地方
0. 整个框架的设计：为什么扫描函数scan要返回Token，而不直接用String打印出来
1. 双目运算符的设计：如何存储，如何打印
2. 很关键的一点：词法分析和语法分析搞混，不需要进行这么多出错处理，这是语法分析该干的事情
    eg：一直在想，正确的NUM、WORD后面的内容
    （当符号词法单元正确时，其后面的字符为空格、制表符、【换行符】？、或注释……）

3. 不会使用调试工具

 */