package demo.inter.stmt;

import demo.inter.expr.Expr;

/**
 * Do语句
 */
public class Do extends Stmt {
    Expr expr;
    Stmt stmt;

    public Do() {
        expr = null;
        stmt = null;
    }

    @Override
    public void gen(int b, int a) {
        after = a;
        int label = newlabel();     //用于expr的标号
        stmt.gen(b, label);
        emitlabel(label);
        expr.jumping(b, 0);
    }

}
