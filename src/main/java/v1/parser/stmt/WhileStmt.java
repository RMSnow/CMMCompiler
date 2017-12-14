package v1.parser.stmt;

import v1.parser.node.Stmt;

/**
 * 循环语句
 * <p>
 * WhileStmt
 * -> while ( Cdt ) Block
 */
public class WhileStmt extends Stmt {
    private CdtStmt cdt;

    public void setCdt(CdtStmt cdt) {
        this.cdt = cdt;
    }

    @Override
    public void printNode() {
        super.printNode();
        System.out.println("WhileStmt -> while ( Cdt ) Block " +
                "-> while (" + cdt.getValue() + ") Block");
    }
}
