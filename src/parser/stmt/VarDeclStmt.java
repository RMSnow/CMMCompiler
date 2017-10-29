package parser.stmt;

import lexer.Token.Tag;
import lexer.Token.Word;
import parser.Parser;
import parser.node.Node;
import parser.node.Stmt;

import java.io.IOException;

import static parser.Parser.look;

/**
 * 声明语句
 * VarDecl
 * -> Type VarList ;
 * Type
 * -> int
 * | real
 * | int[]---------------------------
 * | real[]
 * VarList
 * -> ident OtherIdent
 * OtherIdent
 * -> , ident OtherIdent
 * | [null]
 */

public class VarDeclStmt extends Stmt {
    private String type;
    private Stmt varList;

    public void setType(String type) {
        this.type = type;
    }

    public void setVarList(Stmt varList) {
        this.varList = varList;
    }

    @Override
    public void printNode() {
        super.printNode();
        System.out.println("VarDecl -> Type VarList; " +
                "-> " + type + " VarList; " +
                "-> " + type + " " + varList.getValue() + ";");
    }

    /**
     * VarList
     * -> ident OtherIdent
     *
     * @param node
     * @return
     * @throws IOException
     */
    public Stmt varList(Node node) throws IOException {
        node.addValue(((Word) Parser.look).lexeme);
        Parser.match(Tag.IDENTIFIER);
        return otherIdent(node);
    }

    /**
     * OtherIdent
     * -> , ident OtherIdent
     * | [null]
     *
     * @param node
     * @return
     * @throws IOException
     */
    public Stmt otherIdent(Node node) throws IOException {
        if (Parser.look.tag == ',') {
            Parser.match(',');
            node.addValue(", " + ((Word) Parser.look).lexeme);
            Parser.match(Tag.IDENTIFIER);
            return otherIdent(node);
        }
        return Stmt.Null;
    }

}
