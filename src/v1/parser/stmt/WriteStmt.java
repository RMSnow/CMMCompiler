package v1.parser.stmt;

import v1.parser.node.Expr;
import v1.parser.node.Stmt;

/**
 * 输出语句
 * <p>
 * WriteStmt
 * -> write ( Expr ) ;
 */
public class WriteStmt extends Stmt {
    private Expr expr;

    public void setExpr(Expr expr) {
        this.expr = expr;
    }

    @Override
    public void printNode() {
        super.printNode();
        System.out.println("WriteStmt -> write ( Expr ) ; " +
                "-> write(" + expr.getValue() + ");");
    }
}
