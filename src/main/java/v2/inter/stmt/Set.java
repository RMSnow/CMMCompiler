package v2.inter.stmt;

import v2.inter.expr.Expr;
import v2.inter.expr.Id;
import v2.symbols.Type;

/**
 * 赋值语句（左部为标识符，右部为一个表达式）
 */
public class Set extends Stmt{
    public Id id;
    public Expr expr;

    public Set(Id i, Expr x) {
        id = i;
        expr = x;
        if (check(id.type, expr.type) == null) {
            error("type error");
        }
    }

    public Type check(Type p1, Type p2) {
        if (Type.numeric(p1) && Type.numeric(p2)) {
            return p2;
        } else if (p1 == Type.Bool && p2 == Type.Bool) {
            return p2;
        } else {
            return null;
        }
    }

    @Override
    public void gen(int b, int a) {
        emit(id.toString() + " = " + expr.gen().toString());
    }

}
