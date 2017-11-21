package demo.inter.boolExpr;

import demo.inter.expr.Expr;
import demo.lexer.Token;

/**
 * 逻辑运算符And
 */
public class And extends Logical {
    public And(Token tok, Expr x1, Expr x2) {
        super(tok, x1, x2);
    }

    @Override
    public void jumping(int t, int f) {
        int label = f != 0 ? f : newlabel();
        expr1.jumping(0, label);
        expr2.jumping(t, f);
        if (f == 0) {
            emitlabel(label);
        }
    }
}
