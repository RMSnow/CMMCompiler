package v2.inter.stmt;

import v2.inter.expr.Expr;
import v2.symbols.Type;
import v3.parser.Parser;

/**
 * WhileStmt -> while ( Bool ) Stmt
 */
public class While extends Stmt {
    Expr bool;
    Stmt stmt;

    public While() {
    }

    public void init(Expr bool, Stmt stmt) {
        this.bool = bool;
        this.stmt = stmt;

        if (bool.type != Type.Bool) {
            bool.error("boolean required in while");
        }

        //endLine
        endLine = stmt.endLine;
    }

    @Override
    public void gen(int b, int a) {
        Parser.out.println("BEGIN---------------------------");
        after = a;      //保存下一条指令的标号
        bool.jumping(0, a);

        int label = newlabel();
        emitlabel(label);
        stmt.gen(label, b);
        emit("goto L" + b);
        Parser.out.println("END-----------------------------");
    }

    @Override
    //goto不输出行号
    public void emit(String s){
        Parser.out.printf("\t" + s);
        Parser.out.println();
    }

}
