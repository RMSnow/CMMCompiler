package parser.node;

import lexer.Lexer;
import parser.ParserException;

/**
 * 抽象语法树的结点
 */
public class Node {
    public int startLine = 0;
    public int endLine = 0;
    public static final boolean STARTLINE = true;
    public static final boolean ENDLINE = false;

    private String value = "";

    public Node(){
        startLine = Lexer.line;
    }

    //修改结点值
    public void addValue(String s){
        value += s;
    }

    //获取结点值
    public String getValue(){
        return value;
    }

    public void printNode(){
        if(this.startLine != this.endLine){
            System.out.printf("[Line "+this.endLine+": From Line "+this.startLine+"] ");
        }else{
            System.out.printf("[Line "+this.startLine +"] ");
        }
    }

    //------------------------------------------
    public void error(){
        ParserException.error();
    }

}
