package parser;

import lexer.Lexer;
import lexer.Token.Tag;
import lexer.Token.Token;
import lexer.Token.Word;
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

    //向前读一个Token
    static void move() throws IOException {
        look = lexer.scan();
    }

    //--------------------------------
    void error() {
        ParserException.error();
    }

    //判断是否匹配
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

    //判断是否匹配且修改结点所在行
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
    public void program() throws IOException {
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
    SubProgram subProgram() throws IOException {
        switch (look.tag){
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
    Block block() throws IOException {
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
    Stmt stmt() throws IOException {
        if (look instanceof Word) {
            switch (((Word) look).lexeme) {
                case "int":
                case "real":
                    //VarDecl -> Type VarList ;
                    VarDeclStmt varDeclStmt = new VarDeclStmt();
                    String type = ((Word) look).lexeme;
                    Stmt varListNode = new Stmt();

                    match();
                    varDeclStmt.varList(varListNode);
                    match(';', varDeclStmt, Node.ENDLINE);

                    varDeclStmt.setType(type);
                    varDeclStmt.setVarList(varListNode);
                    varDeclStmt.printNode();

                    return varDeclStmt;
                case "while":
                    return new WhileStmt();
                case "read":
                    return new ReadStmt();
                case "write":
                    return new WriteStmt();
                case "if":
                    return new IfStmt();
                default:
                    //AssignStmt  -> ident = Expr ;
                    AssignStmt assignStmt = new AssignStmt(((Word) look).lexeme);

                    match();
                    match('=');
                    Expr expr = new Expr();
                    match(';', assignStmt, Node.ENDLINE);

                    assignStmt.setExpr(expr);
                    assignStmt.printNode();

                    return assignStmt;
            }
        }

        error();
        return null;
    }

}


/*

1. 打印结点信息，子程序、块、声明语句测试 ok
（1）输出行号的范围 ok
（2）得出识别一个句子的最左推导 ok

2. 赋值语句 ok

3. While语句

4. Read语句与Write语句

5. If语句

所有的都做完了，最后才是
（1）出错处理
（2）注释
（3）注解的完善

 */

