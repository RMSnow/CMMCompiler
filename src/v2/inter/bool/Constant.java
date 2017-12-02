package v2.inter.bool;

import v2.inter.expr.Expr;
import v2.lexer.Num;
import v2.lexer.Token;
import v2.lexer.Word;
import v2.symbols.Type;

/**
 * 创造常量对象??????????????????????
 */
public class Constant extends Expr{

    public static final Constant
            True = new Constant(Word.True, Type.Bool),
            False = new Constant(Word.False, Type.Bool);

    public Constant(Token tok, Type p) {
        super(tok, p);
    }

    public Constant(int i) {     //为一个整数创建常量对象
        super(new Num(i), Type.Int);
    }

    @Override
    public void jumping(int t, int f) {
        if (this == True && t != 0) {
            emit("goto L" + t);
        } else if (this == False && f != 0) {
            emit("goto L" + f);
        }
    }
}
