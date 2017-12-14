package v2.inter.stmt;

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
    }
}
