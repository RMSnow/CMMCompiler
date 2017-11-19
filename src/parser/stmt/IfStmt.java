package parser.stmt;

import lexer.token.Tag;
import parser.Parser;
import parser.node.Node;
import parser.node.Stmt;

import java.io.IOException;
import java.util.ArrayList;

/**
 * 选择语句
 * <p>
 * IfStmt
 * -> if ( Cdt ) { SubProgram } OtherIfStmt
 * <p>
 * OtherIfStmt
 * -> else OtherIfStmt1
 * | [null]
 * <p>
 * OtherIfStmt1
 * -> { SubProgram }
 * | if ( Cdt ) { SubProgram } ElseIfStmt ElseStmt
 * <p>
 * ElseIfStmt
 * -> else if ( Cdt ) { SubProgram } ElseIfStmt
 * | [null]
 * <p>
 * ElseStmt
 * -> else { SubProgram }
 * | [null]
 */
public class IfStmt extends Stmt {
    private CdtStmt cdtStmt;
    private ArrayList<CdtStmt> otherIfCdt = new ArrayList<>();
    private int elseSum = 0;

    public void setCdtStmt(CdtStmt cdtStmt) {
        this.cdtStmt = cdtStmt;
    }

    @Override
    public void printNode() {
        super.printNode();
        System.out.printf("IfStmt -> if ( Cdt ) { SubProgram } OtherIfStmt " +
                "-> if (" + cdtStmt.getValue() + ") { SubProgram } ");

        if (otherIfCdt.size() != 0) {
            for (int i = 0; i < otherIfCdt.size(); i++) {
                System.out.printf("else if (" + otherIfCdt.get(i).getValue() +
                        ") { SubProgram } ");
            }
        }

        for (int i = 0; i < elseSum - otherIfCdt.size(); i++) {
            System.out.printf("else { SubProgram } ");
        }

        System.out.println();
    }

    /**
     * OtherIfStmt
     * -> else OtherIfStmt1
     * | [null]
     *
     * @return
     * @throws IOException
     */
    public Stmt otherIfStmt() throws IOException {
        if (Parser.look.tag == Tag.KEYWORD) {
            Parser.match();
            elseSum++;
            return otherIfStmt1();
        }
        return Stmt.Null;
    }

    /**
     * OtherIfStmt1
     * -> { SubProgram }
     * | if ( Cdt ) { SubProgram } ElseIfStmt ElseStmt
     *
     * @return
     * @throws IOException
     */
    public Stmt otherIfStmt1() throws IOException {
        if (Parser.look.tag == '{') {
            Parser.match('{');
            Parser.subProgram();
            Parser.match('}', this, Node.ENDLINE);
            return Stmt.Null;
        } else {
            Parser.match();
            Parser.match('(');
            otherIfCdt.add(new CdtStmt());
            Parser.match(')');
            Parser.match('{');
            Parser.subProgram();
            Parser.match('}', this, Node.ENDLINE);
            elseIfStmt();
            return elseStmt();
        }
    }

    /**
     * ElseIfStmt
     * -> else if ( Cdt ) { SubProgram } ElseIfStmt
     * | [null]
     *
     * @return
     * @throws IOException
     */
    public Stmt elseIfStmt() throws IOException {
        if (Parser.look.tag == Tag.KEYWORD) {
            Parser.match();
            elseSum++;

            if (Parser.look.tag == '{') {
                return Stmt.Null;
            }

            Parser.match();
            Parser.match('(');
            otherIfCdt.add(new CdtStmt());
            Parser.match(')');
            Parser.match('{');
            Parser.subProgram();
            Parser.match('}', this, Node.ENDLINE);
            return elseIfStmt();
        }
        return Stmt.Null;
    }

    /**
     * ElseStmt
     * -> else { SubProgram }
     * | [null]
     *
     * @return
     * @throws IOException
     */
    public Stmt elseStmt() throws IOException {
        Parser.match('{');
        Parser.subProgram();
        Parser.match('}', this, Node.ENDLINE);
        return Stmt.Null;
    }

}
