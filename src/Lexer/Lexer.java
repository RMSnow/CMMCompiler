package Lexer;

import java.io.IOException;
import java.util.Hashtable;

/**
 * 词法分析器入口
 */
public class Lexer {
    public int line = 1;        //对输入行计数
    private char peek = ' ';        //存放下一个输入字符
    private Hashtable words = new Hashtable();

    /**
     * 添加保留字
     * @param t
     */
    void reserve(Word t){ words.put(t.lexeme, t);}

    public Lexer(){
        reserve(new Word(Tag.KEYWORD, "if"));
        reserve(new Word(Tag.KEYWORD, "else"));
        reserve(new Word(Tag.KEYWORD,"while"));
        reserve(new Word(Tag.KEYWORD,"read"));
        reserve(new Word(Tag.KEYWORD,"write"));
        reserve(new Word(Tag.KEYWORD,"int"));
        reserve(new Word(Tag.KEYWORD,"real"));

        //算数运算符
        //关系运算符
        //注释
        //界符
    }

    /**
     * 扫描输入字符
     */
    public Token scan() throws IOException {
        //跳过空白符
        //注释
        for( ; ; peek = (char)System.in.read()){
            if(peek == ' ' || peek == '\t')
                continue;
            else if(peek == '\n')
                line++;
            else break;
        }

        //处理数字常量
        if(Character.isDigit(peek)){
            int v = 0;
            do{
                v = 10*v + Character.digit(peek, 10);
                peek = (char)System.in.read();
            }while (Character.isDigit(peek));

            return new Num(v);
        }

        //处理保留字和标识符
        //下划线_
        if(Character.isLetter(peek)){
            StringBuffer b = new StringBuffer();        //预读
            do{
                b.append(peek);
                peek = (char)System.in.read();
            }while (Character.isLetter(peek));

            String s = b.toString();
            Word w = (Word)words.get(s);
            if(w != null)
                return w;

            w = new Word(Tag.IDENTIFIER, s);
            words.put(s, w);
            return  w;
        }

        //运行至此处时，需进行出错处理
        Token t = new Token(peek);
        peek = ' ';
        return t;
    }



}
