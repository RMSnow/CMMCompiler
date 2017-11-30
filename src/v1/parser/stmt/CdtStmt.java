package v1.parser.stmt;

import v1.lexer.token.BinaryOperator;
import v1.lexer.token.Tag;
import v1.parser.Parser;
import v1.parser.node.Expr;
import v1.parser.node.Stmt;

import java.io.IOException;

/**
 * 条件判断
 * <p>
 * Cdt
 * -> Expr < Expr
 * | Expr > Expr
 * | Expr == Expr
 * | Expr <= Expr
 * | Expr >= Expr
 * | Expr <> Expr
 */
public class CdtStmt extends Stmt {
    private Expr expr1;
    private Expr expr2;
    private String op;

    public CdtStmt() throws IOException {
        expr1 = new Expr();

        if (Parser.look.tag == Tag.BINARY_OPERATOR) {
            op = ((BinaryOperator) Parser.look).operator;
        } else {
            op = String.valueOf((char) Parser.look.tag);
        }
        Parser.match();

        expr2 = new Expr();

        this.addValue(expr1.getValue());
        this.addValue(" " + op + " ");
        this.addValue(expr2.getValue());
    }
}
