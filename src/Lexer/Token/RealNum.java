package Lexer.Token;

import Lexer.Lexer;

/**
 * 实数
 */
public class RealNum extends Token {
    public final Num number;
    public final Num fraction;

    public RealNum(Num n, Num f) {
        super(Tag.REAL_NUM);
        number = n;
        fraction = f;
    }
}
