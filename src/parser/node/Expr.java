package parser.node;

import lexer.Token.*;
import parser.Parser;

import java.io.IOException;

/**
 * 表达式结点
 * <p>
 * Expr    -> Term OtherTerm
 * <p>
 * OtherTerm   -> + Term OtherTerm
 * -> - Term OtherTerm
 * -> [null]
 * <p>
 * Term    -> Factor OtherFactor
 * <p>
 * OtherFactor -> * Factor OtherFactor
 * -> / Factor OtherFactor
 * -> [null]
 * <p>
 * Factor  -> ident
 * -> ident [ Expr ]
 * -> ( Expr )
 */
public class Expr extends Node {
//    public Token op;

    //    public Type type;
//
//    Expr(Token token, Type type){
//        op = token;
//        this.type = type;
//    }
    public static Expr Null = null;

    //Expr    -> Term OtherTerm
    public Expr() throws IOException {
        term();
        otherTerm();
    }

    //Term    -> Factor OtherFactor
    public Expr term() throws IOException {
        factor();
        otherFactor();
        return Null;
    }

    //OtherTerm   -> + Term OtherTerm
    //            -> - Term OtherTerm
    //            -> [null]
    public Expr otherTerm() throws IOException {
        switch (Parser.look.tag) {
            case '+':
                this.addValue(" + ");
                Parser.match('+');
                term();
                otherTerm();
                return Null;
            case '-':
                this.addValue(" - ");
                Parser.match('-');
                term();
                otherTerm();
                return Null;
            default:
                return Null;
        }
    }

    //Factor
    // -> ident
    // -> ident [ Expr ]       先忽略这个
    // -> [Num]
    // -> ( Expr )
    public Expr factor() throws IOException {
//        if(Parser.look.tag == Tag.IDENTIFIER){
//            this.addValue(((Word)Parser.look).lexeme);
//            Parser.match();
//
//            return Null;
//        }else{
//            this.addValue("(");
//            Parser.match('(');
//            Expr expr = new Expr();
//            this.addValue(")");
//            Parser.match(')');
//
//            return expr;
//        }

        switch (Parser.look.tag) {
            case Tag.IDENTIFIER:
                this.addValue(((Word) Parser.look).lexeme);
                Parser.match();

                return Null;
            case '(':
                this.addValue("(");
                Parser.match('(');
                Expr expr = new Expr();
                this.addValue(expr.getValue() + ")");
                Parser.match(')');

                return expr;
            case Tag.NUM:
                this.addValue(String.valueOf(((Num) Parser.look).value));
                Parser.match();

                return Null;
            case Tag.REAL_NUM:
                this.addValue(String.valueOf(((RealNum) Parser.look).number.value) +
                        "." + String.valueOf(((RealNum) Parser.look).fraction.value));
                Parser.match();

                return Null;
            default:
                return null;
        }
    }

    //OtherFactor
    // -> * Factor OtherFactor
    // -> / Factor OtherFactor
    // -> [null]
    public Expr otherFactor() throws IOException {
        switch (Parser.look.tag) {
            case '*':
                this.addValue(" * ");
                Parser.match('*');
                factor();
                otherFactor();
                return Null;
            case '/':
                this.addValue(" / ");
                Parser.match('/');
                factor();
                otherFactor();
                return Null;
            default:
                return Null;
        }
    }
}
