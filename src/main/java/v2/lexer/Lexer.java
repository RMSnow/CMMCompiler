package v2.lexer;

import v2.symbols.Type;

import java.io.IOException;
import java.util.Hashtable;

/**
 * 词法分析器
 */
public class Lexer {
    public static int line = 1;
    char peek = ' ';
    Hashtable words = new Hashtable();

    public boolean isScanFromGUI = false;

    private String textOfEditor;        //编辑区文本
    private int indexOfString = 0;      //编辑区字符串索引

    public Lexer() {
        init();
    }

    public Lexer(String textOfEditor) {
        init();
        this.textOfEditor = textOfEditor;
        isScanFromGUI = true;
    }

    public void init() {
        //保留字
        reserve(new Word("if", Tag.IF));
        reserve(new Word("else", Tag.ELSE));
        reserve(new Word("while", Tag.WHILE));
        reserve(new Word("do", Tag.DO));
        reserve(new Word("break", Tag.BREAK));
        reserve(new Word("read", Tag.READ));
        reserve(new Word("write", Tag.WRITE));
        reserve(Word.True);
        reserve(Word.False);

        //在其他地方定义的对象的词素
        reserve(Type.Int);
        reserve(Type.Char);
        reserve(Type.Bool);
        reserve(Type.Float);
    }

    void reserve(Word w) {
        words.put(w.lexeme, w);
    }

    void readch() throws IOException {
        if (isScanFromGUI){
            peek = getCharFromText();
        }else {
            peek = (char) System.in.read();
        }
    }

    boolean readch(char c) throws IOException {
        readch();
        if (peek != c) {
            return false;
        }
        peek = ' ';
        return true;
    }

    char getCharFromText() {
        if (indexOfString == textOfEditor.length()) {
            return '#';
        }
        return textOfEditor.charAt(indexOfString++);
    }

    public Token scan() throws IOException {
        //略过所有的空白符
        for (; ; readch()) {
            if (peek == ' ' || peek == '\t') {
                continue;
            } else if (peek == '\n') {
                line++;
            }
            else if (peek == '#') {     //输入结束符
                return new Token(Tag.END);
            }
            else {
                break;
            }
        }

        //识别复合词法单元
        switch (peek) {
            case '&':
                if (readch('&')) {
                    return Word.and;
                } else {
                    return new Token('&');
                }
            case '|':
                if (readch('|')) {
                    return Word.or;
                } else {
                    return new Token('|');
                }
            case '=':
                if (readch('=')) {
                    return Word.eq;
                } else {
                    return new Token('=');
                }
            case '!':
                if (readch('=')) {
                    return Word.ne;
                } else {
                    return new Token('!');
                }
            case '<':
                if (readch('=')) {
                    return Word.le;
                } else {
                    return new Token('<');
                }
            case '>':
                if (readch('=')) {
                    return Word.le;
                } else {
                    return new Token('>');
                }
            case '/':       //处理单行注释----------------注意行号
                if (readch('/')){
                    do {
                        readch();
                    }while (peek != '\n');

                    line++;
                    peek = ' ';
                    return scan();
                }else {
                    return new Token('/');
                }
        }

        //处理数字
        if (Character.isDigit(peek)) {
            int v = 0;
            do {
                v = 10 * v + Character.digit(peek, 10);
                readch();
            } while (Character.isDigit(peek));

            if (peek != '.') {
                return new Num(v);
            }

            float x = v;
            float d = 10;
            for (; ; ) {
                readch();
                if (!Character.isDigit(peek)) {
                    break;
                }
                x = x + Character.digit(peek, 10) / d;
                d = d * 10;
            }
            return new Real(x);
        }

        //处理Word
        if (Character.isLetter(peek)) {
            StringBuffer b = new StringBuffer();
            do {
                b.append(peek);
                readch();
            } while (Character.isLetterOrDigit(peek));

            String s = b.toString();
            Word w = (Word) words.get(s);

            if (w != null) {
                return w;
            }

            w = new Word(s, Tag.ID);
            words.put(s, w);
            return w;
        }

        //最后，对任意字符都以词法单元返回
        Token token = new Token(peek);
        peek = ' ';
        return token;
    }
}
