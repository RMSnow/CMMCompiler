package v2.inter.stmt;

import v2.inter.expr.Expr;
import v2.symbols.Type;
import v3.parser.Parser;

/**
 * 条件语句的Else部分
 */
public class Else extends Stmt{
    Expr expr;
    Stmt stmt1, stmt2;

    public Else(Expr x, Stmt s1, Stmt s2) {
        expr = x;
        stmt1 = s1;
        stmt2 = s2;

        if (expr.type != Type.Bool) {
            expr.error("boolean required in if");
        }

        //endLine
        endLine = stmt2.endLine;
    }

    @Override
    public void gen(int b, int a) {
        Parser.out.println("BEGIN---------------------------");
        int label1 = newlabel();        //label1用于语句stmt1
        int label2 = newlabel();        //label2用于语句stmt2
        expr.jumping(0, label2);     //为真时控制流穿越到stmt1
        emitlabel(label1);
        stmt1.gen(label1, a);
        emit("goto L" + a);
        emitlabel(label2);
        stmt2.gen(label2, a);
        Parser.out.println("END-----------------------------");
    }

    @Override
    //goto不输出行号
    public void emit(String s){
        Parser.out.printf("\t" + s);
        Parser.out.println();
    }
}
