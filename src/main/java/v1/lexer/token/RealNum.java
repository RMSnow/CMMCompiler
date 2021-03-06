package v1.lexer.token;

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
