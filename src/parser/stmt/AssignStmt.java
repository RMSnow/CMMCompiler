package parser.stmt;

import parser.node.Expr;
import parser.node.Stmt;

/**
 * 赋值语句
 * AssignStmt
 * -> ident = Expr ;
 */
public class AssignStmt extends Stmt {
    private String ident;
    private Expr expr;

    public AssignStmt(String ident) {
        this.ident = ident;
    }

    public void setExpr(Expr expr) {
        this.expr = expr;
    }

    @Override
    public void printNode() {
        super.printNode();
        System.out.println("AssignStmt -> ident = Expr ;" +
                " -> " + this.ident + " = Expr ;" +
                " -> " + this.ident + " = " + expr.getValue() + " ;");
    }
}
