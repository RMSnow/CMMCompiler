package v2.inter.stmt;

import v2.inter.Node;
import v3.parser.Parser;

/**
 * 语句构造基类
 */
public class Stmt extends Node{
    public static Stmt Null = new Stmt();
    public static Stmt Enclosing = Stmt.Null;       //用于break语句
    int after = 0;      //保存语句的下一条指令的标号

    protected int endLine;      //语句结束时的行号

    public Stmt() {
        endLine = lexLine;
    }

    /**
     * 三地址码的生成
     *
     * @param b 语句开始处的标号
     * @param a 语句下一条指令的标号
     */
    public void gen(int b, int a) {
    }

}
