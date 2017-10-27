package parser;

import lexer.Lexer;
import lexer.Token.Tag;
import lexer.Token.Token;
import lexer.Token.Word;
import parser.node.Block;
import parser.node.Stmt;
import parser.node.SubProgram;
import parser.stmt.*;

import java.io.IOException;

/**
 * 语法分析器
 */
public class Parser {
    private Lexer lexer;
    private Token look;     //向前看词法单元

    public Parser(Lexer lexer) throws IOException {
        this.lexer = lexer;
        move();
    }

    //向前读一个Token
    void move() throws IOException {
        look = lexer.scan();
    }

    //--------------------------------
    void error() {
        ParserException.error();
    }

    //判断是否匹配
    void match(int t) throws IOException {
        if (look.tag == t) {
            move();
        } else {
            ParserException.error();
        }
    }
    void match() throws IOException {
        move();
    }

    /**
     * 递归下降分析的入口
     * @throws IOException
     */
    public void program() throws IOException {
        subProgram();
    }

    //SubProgram -> Stmt
    //           -> Block
    SubProgram subProgram() throws IOException {
        //是Follow么？---------------------------
//        if(look.tag == '}'){
//            return Stmt.Null;
//        }
        if (look.tag == '{') {
            //return block();
            return new SubProgram(block());
        }
        //return stmt();
        return new SubProgram(stmt());
    }

    //Block   -> { SubProgram }
    Block block() throws IOException {
        match('{');
        SubProgram subProgram = subProgram();
        match('}');
        return new Block(subProgram);
    }

    /*
    Stmt    -> VarDecl
            -> AssignStmt
            -> IfStmt
            -> WhileStmt
            -> ReadStmt
            -> WriteStmt
    */
    Stmt stmt() throws IOException {
        if (look.tag == Tag.KEYWORD) {
            switch (((Word) look).lexeme) {
                case "int":
                case "real":
                    /*
                    VarDecl -> Type VarList ;

                    Type    -> int
                            -> real
                            //暂时不处理下面两个-----------------
                            -> int[]
                            -> real[]

                    VarList -> ident OtherIdent

                    OtherIdent  -> , ident OtherIdent
                                -> [null]
                     */

                    match();
                    Stmt varList = varList();
                    match(';');

                    VarDeclStmt varDeclStmt = new VarDeclStmt("undefined-type", varList);
                    varDeclStmt.printSyntaxTree();
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
                    return new AssignStmt();
            }
        }

        error();
        return null;
    }

    //VarList -> ident OtherIdent
    Stmt varList() throws IOException {
        match(Tag.IDENTIFIER);
        return otherIdent();
    }

    //OtherIdent  -> , ident OtherIdent
    //            -> [null]
    Stmt otherIdent() throws IOException {
        if(look.tag == ','){
            match(',');
            match(Tag.IDENTIFIER);
            return otherIdent();
        }
        return Stmt.Null;
    }



}


/*
完成声明语句的识别
 */

