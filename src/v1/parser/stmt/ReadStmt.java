package v1.parser.stmt;

import v1.parser.node.Expr;
import v1.parser.node.Stmt;

/**
 * 读取语句
 * <p>
 * ReadStmt
 * -> read ( Expr ) ;
 */
public class ReadStmt extends Stmt {
    private Expr expr;

    public void setExpr(Expr expr) {
        this.expr = expr;
    }

    @Override
    public void printNode() {
        super.printNode();
        System.out.println("ReadStmt -> read ( Expr ) ; " +
                "-> read(" + expr.getValue() + ");");
    }
}

