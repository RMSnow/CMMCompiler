package v2.inter.stmt;

import v3.parser.Parser;

/**
 * BreakStmt -> break ;
 */
public class Break extends Stmt{
    Stmt stmt;

    public Break() {
        if (Stmt.Enclosing == Stmt.Null) {
            error("unclosed break");
        }
        stmt = Stmt.Enclosing;
    }

    @Override
    public void gen(int b, int a) {
        emit("goto L" + stmt.after);
        Parser.out.println("END-----------------------------");
    }

    @Override
    //goto不输出行号
    public void emit(String s){
        Parser.out.printf("\t" + s);
        Parser.out.println();
    }
}
