package v1.lexer.token;

/**
 * 标识符与关键字
 */
public class Word extends Token {
    public final String lexeme;

    public Word(int t, String s) {
        super(t);
        lexeme = new String(s);
    }
}
