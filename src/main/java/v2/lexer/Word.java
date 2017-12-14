package v2.lexer;

/**
 * 对下列内容进行管理：
 * （1）保留字、标识符和像&&这样的复合词法单元的词素
 * （2）中间代码中运算符的书写形式，比如单目减号。如：源文本中-2的中间形式是minus 2
 */
public class Word extends Token {
    public static final Word
            and = new Word("&&", Tag.AND),
            or = new Word("||", Tag.OR),
            eq = new Word("==", Tag.EQ),
            ne = new Word("!=", Tag.NE),
            le = new Word("<=", Tag.LE),
            ge = new Word(">=", Tag.GE),
            minus = new Word("minus", Tag.MINUS),
            True = new Word("true", Tag.TRUE),
            False = new Word("false", Tag.FALSE),
            temp = new Word("t", Tag.TEMP);
    public String lexeme = "";

    public Word(String s, int tag) {
        super(tag);
        lexeme = s;
    }

    public String toString() {
        return lexeme;
    }
}
