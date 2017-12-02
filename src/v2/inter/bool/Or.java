package v2.inter.bool;

import v2.inter.expr.Expr;
import v2.lexer.Token;

/**
 * 逻辑运算符Or
 */
public class Or extends Logical{
    public Or(Token op, Expr x1, Expr x2) {
        super(op, x1, x2);
    }

    @Override
    public void jumping(int t, int f) {
        int label = t != 0 ? t : newlabel();
        expr1.jumping(label, 0);
        expr2.jumping(t, f);
        if (t == 0) {
            emitlabel(label);
        }
    }
}
