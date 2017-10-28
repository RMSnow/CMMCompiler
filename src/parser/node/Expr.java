package parser.node;

import lexer.Token.Token;
import parser.Parser;

/**
 * 表达式结点
 *
 * Expr    -> Term OtherTerm
 *
 * OtherTerm   -> + Term OtherTerm
 *             -> - Term OtherTerm
 *             -> [null]
 *
 * Term    -> Factor OtherFactor
 *
 * OtherFactor -> * Factor OtherFactor
 *             -> / Factor OtherFactor
 *             -> [null]
 *
 * Factor  -> ident
 *         -> ident [ Expr ]
 *         -> ( Expr )
 *
 */
public class Expr extends Node{
    public Token op;

//    public Type type;
//
//    Expr(Token token, Type type){
//        op = token;
//        this.type = type;
//    }

    //Term    -> Factor OtherFactor
    public Expr term(){
        factor();
        otherFactor();

        return null;
    }

    //OtherTerm   -> + Term OtherTerm
    //            -> - Term OtherTerm
    //            -> [null]
    public Expr otherTerm(){
        switch (Parser.look.tag){
            case '+':
                
            case '-':
        }

        return null;
    }

    //Factor
    // -> ident
    // -> ident [ Expr ]
    // -> ( Expr )
    public Expr factor(){

        return null;
    }

    //OtherFactor
    // -> * Factor OtherFactor
    // -> / Factor OtherFactor
    // -> [null]
    public Expr otherFactor(){

        return null;
    }
}
