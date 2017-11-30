package v1.parser.stmt;

import v1.lexer.token.Tag;
import v1.lexer.token.Word;
import v1.parser.Parser;
import v1.parser.node.Stmt;

import java.io.IOException;


/**
 * 声明语句
 * <p>
 * VarDecl
 * -> Type VarList ;
 * <p>
 * Type
 * -> int
 * | real
 * | int[]
 * | real[]
 * <p>
 * VarList
 * -> ident OtherIdent
 * <p>
 * OtherIdent
 * -> , ident OtherIdent
 * | [null]
 */
public class VarDeclStmt extends Stmt {
    private String type;
    private Stmt varList = new Stmt();

    public void setType(String type) {
        this.type = type;
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
     * @return
     * @throws IOException
     */
    public Stmt varList() throws IOException {
        varList.addValue(((Word) Parser.look).lexeme);
        Parser.match(Tag.IDENTIFIER);
        return otherIdent();
    }

    /**
     * OtherIdent
     * -> , ident OtherIdent
     * | [null]
     *
     * @return
     * @throws IOException
     */
    public Stmt otherIdent() throws IOException {
        if (Parser.look.tag == ',') {
            Parser.match(',');
            varList.addValue(", " + ((Word) Parser.look).lexeme);
            Parser.match(Tag.IDENTIFIER);
            return otherIdent();
        }
        return Stmt.Null;
    }

}
