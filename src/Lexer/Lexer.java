package Lexer;

import java.io.IOException;
import java.util.Hashtable;

/**
 * 词法分析程序
 */
public class Lexer {
    public int line = 1;        //对输入行计数
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

        //单目关系运算符
        symbols.put(">", new Token('>'));
        symbols.put("<", new Token('<'));
        //symbols.put(">=", new Token(Tag.Symbol));
        //symbols.put("<=", new Token(Tag.Symbol));
        //symbols.put("==", new Token(Tag.Symbol));
        //symbols.put("<>", new Token(Tag.Symbol));

        //界符
        symbols.put("(", new Token('('));
        symbols.put(")", new Token(')'));
        symbols.put("{", new Token('{'));
        symbols.put("}", new Token('}'));
        symbols.put("[", new Token('['));
        symbols.put("]", new Token(']'));
        symbols.put(";", new Token(';'));

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

            //异常处理(不包括注释)----------------------------------------
            Token t = (Token)symbols.get(String.valueOf(peek));
            //当Num词法单元正确时，其后面的字符为空格、制表符、换行符、特殊符号或注释
            if(peek == ' ' || peek == '\t' || peek == '\n' || t != null)
                return new Num(v);
            else{
                ExceptionHandle.NumException();
                return null;
            }
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
                ExceptionHandle.IdentifierException();
                return null;
            }

            //异常处理（不包括注释）-----------------------------------------------
            Token t = (Token)symbols.get(String.valueOf(peek));
            //当Word词法单元正确时，其后面的字符为空格、制表符、换行符、特殊符号或注释
            if(peek == ' ' || peek == '\t' || peek == '\n' || t != null){
                //词法单元为关键字
                Word w = (Word)words.get(s);
                if(w != null)
                    return w;

                //词法单元为标识符
                w = new Word(Tag.IDENTIFIER, s);
                words.put(s, w);
                return  w;
            }else{
                ExceptionHandle.IdentifierException();
                return null;
            }
        }

        //若遇到下划线------------------------------------------------


        //处理单目的特殊符号，存在问题------------------------------------------
        Token t = new Token(peek);
        //peek = ' ';
        return t;
    }
}

/*
1. 编写test，测试main
2. 算数运算符
3. 关系运算符
4. 实数
5. 注释

测试用例
 */

/*
总结：
1. char与int
2. 注意，对String来说，=，与compare
3. 异常处理：用try
 */