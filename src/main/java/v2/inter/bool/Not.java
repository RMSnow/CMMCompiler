package v2.inter.bool;

import v2.inter.expr.Expr;
import v2.lexer.Token;

/**
 * 逻辑运算符Not
 */
public class Not extends Logical{
    public Not(Token op, Expr x2) {
        super(op, x2, x2);
    }

    @Override
    public void jumping(int t, int f) {
        expr2.jumping(f, t);
    }

    public String toString() {
        return op.toString() + " " + expr2.toString();
    }
}
