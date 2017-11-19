package parser;

import lexer.Lexer;
import lexer.token.Tag;
import lexer.token.Token;
import lexer.token.Word;
import parser.node.*;
import parser.stmt.*;

import java.io.IOException;

/**
 * 语法分析器
 */
public class Parser {
    private static Lexer lexer;
    public static Token look;     //向前看词法单元

    public Parser(Lexer lexer) throws IOException {
        this.lexer = lexer;
        move();
    }

    /**
     * 向前读一个Token
     *
     * @throws IOException
     */
    static void move() throws IOException {
        look = lexer.scan();
    }

    /**
     * 判断是否匹配
     *
     * @param t
     * @throws IOException
     */
    public static void match(int t) throws IOException {
        if (look.tag == t) {
            move();
        } else {
            ParserException.error();
        }
    }

    public static void match() throws IOException {
        move();
    }

    public static void match(int t, Node node, boolean tag) throws IOException {
        if (look.tag == t) {
            if (tag == Node.ENDLINE) {
                node.endLine = lexer.line;
            }
            move();
        } else {
            ParserException.error();
        }
    }

    /**
     * 递归下降分析的入口
     *
     * @throws IOException
     */
    public static void program() throws IOException {
        subProgram();
    }

    /**
     * SubProgram
     * -> Stmt SubProgram
     * | Block SubProgram
     * | [null]
     *
     * @return
     * @throws IOException
     */
    public static SubProgram subProgram() throws IOException {
        switch (look.tag) {
            case '{':
                new SubProgram(block());
                return subProgram();
            case Tag.IDENTIFIER:
            case Tag.KEYWORD:
                new SubProgram(stmt());
                return subProgram();
            case Tag.ANNOTATION:
                match(Tag.ANNOTATION);
                return subProgram();
            default:
                return SubProgram.Null;
        }
    }

    /**
     * Block
     * -> { SubProgram }
     *
     * @return
     * @throws IOException
     */
    public static Block block() throws IOException {
        Block block = new Block();

        match('{');
        subProgram();
        match('}', block, Node.ENDLINE);

        block.printNode();
        return block;
    }


    /**
     * Stmt
     * -> VarDecl
     * | AssignStmt
     * | IfStmt
     * | WhileStmt
     * | ReadStmt
     * | WriteStmt
     *
     * @return
     * @throws IOException
     */
    public static Stmt stmt() throws IOException {
        Expr expr;
        CdtStmt cdtStmt;

        if (look instanceof Word) {
            switch (((Word) look).lexeme) {
                case "int":
                case "real":
                    //VarDecl -> Type VarList ;
                    VarDeclStmt varDeclStmt = new VarDeclStmt();
                    String type = ((Word) look).lexeme;

                    match();
                    varDeclStmt.varList();
                    match(';', varDeclStmt, Node.ENDLINE);

                    varDeclStmt.setType(type);
                    varDeclStmt.printNode();
                    return varDeclStmt;
                case "while":
                    //WhileStmt   -> while ( Cdt ) { SubProgram }
                    WhileStmt whileStmt = new WhileStmt();

                    match();
                    match('(');
                    cdtStmt = new CdtStmt();
                    match(')');
                    match('{');
                    subProgram();
                    match('}', whileStmt, Node.ENDLINE);

                    whileStmt.setCdt(cdtStmt);
                    whileStmt.printNode();
                    return whileStmt;
                case "read":
                    //ReadStmt    -> read ( Expr ) ;
                    ReadStmt readStmt = new ReadStmt();

                    match();
                    match('(');
                    expr = new Expr();
                    match(')');
                    match(';', readStmt, Node.ENDLINE);

                    readStmt.setExpr(expr);
                    readStmt.printNode();
                    return readStmt;
                case "write":
                    //WriteStmt   -> write ( Expr ) ;
                    WriteStmt writeStmt = new WriteStmt();

                    match();
                    match('(');
                    expr = new Expr();
                    match(')');
                    match(';', writeStmt, Node.ENDLINE);

                    writeStmt.setExpr(expr);
                    writeStmt.printNode();
                    return writeStmt;
                case "if":
                    //IfStmt      -> if ( Cdt ) { SubProgram } OtherIfStmt
                    IfStmt ifStmt = new IfStmt();

                    match();
                    match('(');
                    cdtStmt = new CdtStmt();
                    match(')');
                    match('{');
                    subProgram();
                    match('}', ifStmt, Node.ENDLINE);
                    ifStmt.otherIfStmt();

                    ifStmt.setCdtStmt(cdtStmt);
                    ifStmt.printNode();
                    return ifStmt;
                default:
                    //AssignStmt  -> ident = Expr ;
                    AssignStmt assignStmt = new AssignStmt(((Word) look).lexeme);

                    match();
                    match('=');
                    expr = new Expr();
                    match(';', assignStmt, Node.ENDLINE);

                    assignStmt.setExpr(expr);
                    assignStmt.printNode();

                    return assignStmt;
            }
        }
        ParserException.error();
        return null;
    }

}

