package demo.inter.boolExpr;

import demo.inter.expr.Expr;
import demo.inter.expr.Temp;
import demo.lexer.Token;
import demo.symbols.Type;

/**
 * 逻辑运算符基类，包括And、Or、Not子类
 */
public class Logical extends Expr {
    public Expr expr1, expr2;

    protected Logical(Token tok, Expr x1, Expr x2) {
        super(tok, null);
        expr1 = x1;
        expr2 = x2;
        type = check(expr1.type, expr2.type);
        if (type == null) {
            error("type error");
        }
    }

    public Type check(Type p1, Type p2) {
        if (p1 == Type.Bool && p2 == Type.Bool) {
            return Type.Bool;
        } else {
            return null;
        }
    }

    @Override
    public Expr gen() {
        int f = newlabel();
        int a = newlabel();
        Temp temp = new Temp(type);
        this.jumping(0, f);
        emit(temp.toString() + " = true");
        emit("goto L" + a);
        emitlabel(f);
        emit(temp.toString() + " = false");
        emitlabel(a);
        return temp;
    }

    public String toString() {
        return expr1.toString() + " " + op.toString() + " " + expr2.toString();
    }
}
