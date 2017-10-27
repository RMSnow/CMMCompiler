package parser.node;

import lexer.Lexer;
import parser.ParserException;

/**
 * 抽象语法树的结点
 */
public class Node {
    //保存了本结点对应的构造在源程序中的行号
    int lexline = 0;

    Node(){
        lexline = Lexer.line;
    }

    void error(){
        ParserException.error();
    }

}
