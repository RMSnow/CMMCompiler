package parser.node;

/**
 * 语句结点
 */
public class Stmt extends Node {
    public Stmt() {
    }

    public Stmt(String s) {
        addValue(s);
    }

    public static Stmt Null = new Stmt();
}
