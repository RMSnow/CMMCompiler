package parser;

import lexer.Lexer;
import lexer.Token.Token;
import parser.Stmt.Stmt;

import java.io.IOException;

/**
 * Created by snow on 23/10/2017.
 */
public class Parser {
    private Lexer lexer;
    private Token look;

    public Parser(Lexer lexer) {
        this.lexer = lexer;
    }

    //向前读一个Token
    void move() throws IOException {
        look = lexer.scan();
    }

    //判断是否匹配
    void match(int t) throws IOException {
        if (look.tag == t) {
            move();
        } else {
            ParserException.error();
        }
    }

    //Program -> SubProgram
    public void program() throws IOException {
        subProgram();
    }

    //SubProgram -> Stmt
    //           -> Block
    Stmt subProgram() throws IOException {
        move();
        if (look.tag == '{') {
            return block();
        }
        return stmt();
    }

    //Block   -> { SubProgram }
    Stmt block() throws IOException {
        match('{');
        subProgram();
        match('}');
        return Stmt.Null;
    }

    /*
    Stmt    -> VarDecl
            -> AssignStmt
            -> IfStmt
            -> WhileStmt
            -> ReadStmt
            -> WriteStmt
    */
    Stmt stmt() {
        
    }


}


