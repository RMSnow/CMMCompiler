package Lexer;

import java.io.IOException;
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
     * @param t
     */
    void reserve(Word t){
        words.put(t.lexeme, t);
    }

    public Lexer(){
        //保留字
        reserve(new Word(Tag.KEYWORD, "if"));
        reserve(new Word(Tag.KEYWORD, "else"));
        reserve(new Word(Tag.KEYWORD,"while"));
        reserve(new Word(Tag.KEYWORD,"read"));
        reserve(new Word(Tag.KEYWORD,"write"));
        reserve(new Word(Tag.KEYWORD,"int"));
        reserve(new Word(Tag.KEYWORD,"real"));

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
        symbols.put(">=", new BinaryOperator(Tag.BINARY_OPERATOR, ">="));
        symbols.put("<=", new BinaryOperator(Tag.BINARY_OPERATOR, "<="));
        symbols.put("==", new BinaryOperator(Tag.BINARY_OPERATOR, "=="));
        symbols.put("<>", new BinaryOperator(Tag.BINARY_OPERATOR, "<>"));
        symbols.put("[]", new BinaryOperator(Tag.BINARY_OPERATOR, "[]"));

        //注释------------------------------------------
    }

    /**
     * 扫描输入字符
     * @return 返回一个词法单元
     * @throws IOException
     */
    public Token scan() throws IOException {
        //跳过空白符
        //注释----------------------------------------
        for( ; ; peek = (char)System.in.read()){
            if(peek == ' ' || peek == '\t')
                continue;
            else if(peek == '\n')
                line++;
            else break;
        }

        //处理数字常量（Num词法单元）
        //实数、浮点数----------------------------------
        if(Character.isDigit(peek)){
            int v = 0;
            do{
                v = 10*v + Character.digit(peek, 10);
                peek = (char)System.in.read();
            }while (Character.isDigit(peek));

            return new Num(v);
        }

        //处理保留字和标识符（Word词法单元）
        if(Character.isLetter(peek)){
            StringBuffer b = new StringBuffer();        //通过缓冲区实现预读
            do{
                b.append(peek);
                peek = (char)System.in.read();
            }while (Character.isLetter(peek) || Character.isDigit(peek) || peek == '_');

            String s = b.toString();

            //判断最后一个字符是否为下划线
            char c = s.charAt(s.length()-1);
            if(c == '_'){
                ExceptionHandle.identifierException();
                return null;
            }

            //词法单元为关键字
            Word w = (Word)words.get(s);
            if(w != null)
                return w;

            //词法单元为标识符
            w = new Word(Tag.IDENTIFIER, s);
            words.put(s, w);
            return  w;
        }

        //处理下划线
        if(peek == '_'){
            ExceptionHandle.identifierException();
            return null;
        }

        //当程序运行至此处时，说明遇到了特殊符号
        Token t = (Token) symbols.get(String.valueOf(peek));
        if(t == null){      //未定义的符号
            ExceptionHandle.unknownSymbolException(String.valueOf(peek));
            return null;
        }

        //判断是否为双目运算符
        String s = String.valueOf(peek);
        peek = (char)System.in.read();
        s += String.valueOf(peek);

        BinaryOperator b = (BinaryOperator)symbols.get(s);
        if(b != null){
            peek = ' ';
            return b;
        }
        return t;
    }
}

/*

下一步进行：
（1）结束符"#"
（2）文件I／O
（3）出错处理、报错信息完善（如行号，如继承某个类，如用try）
（4）注释// /*
（5）浮点数

 */

/*
总结：
1. char与int
2. 注意，对String来说，=，与compare
3. 异常处理：用try,以及ExceptionHandle继承某个类
4. peek多读以后，会不会"吃掉"一个字符

遇到耗时的地方/设计的地方
0. 整个框架的设计：为什么扫描函数scan要返回Token，而不直接用String打印出来
1. 双目运算符的设计：如何存储，如何打印
2. 很关键的一点：词法分析和语法分析搞混，不需要进行这么多出错处理，这是语法分析该干的事情
    eg：一直在想，正确的NUM、WORD后面的内容
    （当符号词法单元正确时，其后面的字符为空格、制表符、【换行符】？、或注释……）

3. 不会使用调试工具

 */