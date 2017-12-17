package v2.inter;

import v2.lexer.Lexer;
import v3.parser.Parser;

/**
 * 抽象语法树的结点
 */
public class Node {
    /**
     * 生成三地址代码
     */

    public static int labels = 0;
    public int lexLine = 0;        //保存了本结点对应的构造在源程序中的行号
    protected boolean printLine = false;

    protected Node() {
        lexLine = Lexer.line;
    }

    public void error(String s) {
        throw new Error("near line " + lexLine + ": " + s);
    }

    public int newlabel() {
        return ++labels;
    }

    public void emitlabel(int i) {
        Parser.out.println("L" + i + ":");
    }

    public void emit(String s) {
        Parser.out.printf("\t" + s);

        if (!printLine) {
            Parser.out.printf("\t>>> Line " + lexLine);
            printLine = true;       //当行号变化的时候，改为false
        }

        Parser.out.println();
    }

    protected void recordLineNum(){
        if (lexLine != Lexer.line){
            lexLine = Lexer.line;
            printLine = false;
        }
    }
}
