package lexer;

import lexer.Token.*;
import lexer.CharStream.*;

import java.io.*;
import java.util.Hashtable;

/**
 * 词法分析程序
 */
public class Lexer {
    private char peek = ' ';        //存放下一个输入字符
    private Hashtable words = new Hashtable();
    private Hashtable symbols = new Hashtable();
    private CharStream charStream;

    public static int line = 1;        //对输入行计数

    /**
     * 控制台输入
     */
    public Lexer() {
        initialize();
        charStream = new ConsoleCharStream();
    }

    /**
     * 文件输入
     *
     * @param filename
     */
    public Lexer(String filename) {
        initialize();
        try {
            charStream = new FileCharStream(filename);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 添加保留字
     *
     * @param t
     */
    public void reserve(Word t) {
        words.put(t.lexeme, t);
    }

    /**
     * 保留字与特殊符号初始化
     */
    public void initialize() {
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
     * 扫描输入字符，每次读取一个字符
     *
     * @return 返回一个词法单元
     * @throws IOException
     */
    public Token scan() throws IOException {
        //跳过空白
        for (; ; peek = (char) charStream.readChar()) {
            if (peek == ' ' || peek == '\t')
                continue;
            else if (peek == '\n')
                line++;
            else if (peek == (char) (-1))
                return new Token(Tag.END);
            else break;
        }

        //处理数字常量
        if (Character.isDigit(peek)) {
            int v = 0;
            do {
                v = 10 * v + Character.digit(peek, 10);
                peek = (char) charStream.readChar();
            } while (Character.isDigit(peek));

            //整数
            if (peek != '.')
                return new Num(v);

            //浮点数
            peek = (char) charStream.readChar();
            int f = 0;
            if (Character.isDigit(peek)) {
                do {
                    f = 10 * f + Character.digit(peek, 10);
                    peek = (char) charStream.readChar();
                } while (Character.isDigit(peek));
            }

            Num number = new Num(v);
            Num fraction = new Num(f);
            return new RealNum(number, fraction);
        }
        //处理点号'.'
        if (peek == '.') {
            peek = (char) charStream.readChar();
            int f = 0;
            if (Character.isDigit(peek)) {
                do {
                    f = 10 * f + Character.digit(peek, 10);
                    peek = (char) charStream.readChar();
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
                peek = (char) charStream.readChar();
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

        //处理结束符
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
        peek = (char) charStream.readChar();
        s += String.valueOf(peek);

        //单行注释
        if (s.equals("//")) {
            int r;
            do {
                r = charStream.readChar();
            } while (r != '\n');

            peek = ' ';
            return new Token(Tag.ANNOTATION);
        }

        //多行注释
        if (s.equals("/*")) {
            for (; ; ) {
                peek = (char) charStream.readChar();
                if (peek == (char) (-1)) {     //文件输入的多行注释错误
                    LexerException.unclosedMultiAnnotation();
                    return null;
                }
                if (peek == '*') {
                    //预读下一个字符
                    s = String.valueOf(peek);
                    peek = (char) charStream.readChar();
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
