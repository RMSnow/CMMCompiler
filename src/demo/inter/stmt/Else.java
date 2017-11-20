package demo.inter.stmt;

import demo.inter.expr.Expr;
import demo.symbols.Type;

/**
 * 条件语句的Else部分
 */
public class Else extends Stmt {
    Expr expr;
    Stmt stmt1, stmt2;

    public Else(Expr x, Stmt s1, Stmt s2) {
        expr = x;
        stmt1 = s1;
        stmt2 = s2;

        if (expr.type != Type.Bool) {
            expr.error("boolean required in if");
        }
    }

    @Override
    public void gen(int b, int a) {
        int label1 = newlabel();        //label1用于语句stmt1
        int label2 = newlabel();        //label2用于语句stmt2
        expr.jumping(0, label2);     //为真时控制流穿越到stmt1
        emitlabel(label1);
        stmt1.gen(label1, a);
        emit("goto L" + a);
        emitlabel(label2);
        stmt2.gen(label2, a);
    }


}
