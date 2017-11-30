package v2.inter.stmt;

import v2.inter.expr.Expr;
import v2.symbols.Type;

/**
 * DoWhileStmt -> do Stmt while ( Bool )
 */
public class Do extends Stmt {
    Stmt stmt;
    Expr bool;

    public void init(Stmt stmt, Expr bool) {
        this.stmt = stmt;
        this.bool = bool;

        if (bool.type != Type.Bool) {
            bool.error("boolean required in while");
        }
    }

    @Override
    public void gen(int b, int a) {
        after = a;
        int label = newlabel();     //用于bool的标号

        stmt.gen(b, label);
        emitlabel(label);
        bool.jumping(b, 0);
    }
}
