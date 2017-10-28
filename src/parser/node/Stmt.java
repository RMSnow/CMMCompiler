package parser.node;

/**
 * 语句结点
 */
public class Stmt extends Node{
    //处理抽象语法树的构造
    public Stmt() { }
    public Stmt(String s){
        addValue(s);
    }
    public static Stmt Null = new Stmt();
}
