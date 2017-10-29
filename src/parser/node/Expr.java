package parser.node;

import lexer.Token.*;
import parser.Parser;
import parser.ParserException;

import java.io.IOException;

/**
 * 表达式结点
 * <p>
 * Expr
 * -> Term OtherTerm
 * <p>
 * OtherTerm
 * -> + Term OtherTerm
 * | - Term OtherTerm
 * | [null]
 * <p>
 * Term
 * -> Factor OtherFactor
 * <p>
 * OtherFactor
 * -> * Factor OtherFactor
 * | / Factor OtherFactor
 * | [null]
 * <p>
 * Factor
 * -> ident
 * | ident [ Expr ]
 * | [num]
 * | ( Expr )
 */
public class Expr extends Node {

    public static Expr Null = null;

    /**
     * Expr
     * -> Term OtherTerm
     *
     * @throws IOException
     */
    public Expr() throws IOException {
        term();
        otherTerm();
    }

    /**
     * Term
     * -> Factor OtherFactor
     *
     * @return
     * @throws IOException
     */
    public Expr term() throws IOException {
        factor();
        return otherFactor();
    }

    /**
     * OtherTerm
     * -> + Term OtherTerm
     * | - Term OtherTerm
     * | [null]
     *
     * @return
     * @throws IOException
     */
    public Expr otherTerm() throws IOException {
        switch (Parser.look.tag) {
            case '+':
                this.addValue(" + ");
                Parser.match('+');
                term();
                return otherTerm();
            case '-':
                this.addValue(" - ");
                Parser.match('-');
                term();
                return otherTerm();
            default:
                return Null;
        }
    }

    /**
     * Factor
     * -> ident
     * | ident [ Expr ]
     * | [num]
     * | ( Expr )
     *
     * @return
     * @throws IOException
     */
    public Expr factor() throws IOException {
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
                ParserException.error();
                return null;
        }
    }

    /**
     * OtherFactor
     * -> * Factor OtherFactor
     * | / Factor OtherFactor
     * | [null]
     *
     * @return
     * @throws IOException
     */
    public Expr otherFactor() throws IOException {
        switch (Parser.look.tag) {
            case '*':
                this.addValue(" * ");
                Parser.match('*');
                factor();
                return otherFactor();
            case '/':
                this.addValue(" / ");
                Parser.match('/');
                factor();
                return otherFactor();
            default:
                return Null;
        }
    }
}
