package v2.inter.stmt;

import v2.inter.bool.Access;
import v2.inter.expr.Expr;
import v2.inter.expr.Id;
import v2.symbols.Array;
import v2.symbols.Type;

/**
 * 对数组的赋值
 */
public class SetElem extends Stmt{
    public Id array;
    public Expr index;
    public Expr expr;

    public SetElem(Access x, Expr y) {
        array = x.array;
        index = x.index;
        expr = y;
        if (check(x.type, expr.type) == null) {
            error("type error");
        }

        //endLine
        endLine = expr.lexLine;
    }

    public Type check(Type p1, Type p2) {
        if (p1 instanceof Array || p2 instanceof Array) {
            return null;
        } else if (p1 == p2) {
            return p2;
        } else if (Type.numeric(p1) && Type.numeric(p2)) {
            return p2;
        } else {
            return null;
        }
    }

    @Override
    public void gen(int b, int a) {
        String s1 = index.reduce().toString();
        String s2 = expr.reduce().toString();
        emit(array.toString() + "[" + s1 + "] = " + s2);
    }
}
