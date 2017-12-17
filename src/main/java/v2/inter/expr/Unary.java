package v2.inter.expr;

import v2.lexer.Token;
import v2.symbols.Type;

/**
 * 单目运算符: Unary expr (注：此处只处理单目减法)
 */
public class Unary extends Op {
    Expr expr;

    public Unary(Token op, Expr expr) {
        super(op, null);
        this.expr = expr;

        type = Type.max(Type.Int, expr.type);
        if (type == null) {
            error("type error");
        }
    }

    @Override
    public Expr gen() {
        recordLineNum();
        return new Unary(op, expr.reduce());
    }

    public String toString() {
        return op.toString() + " " + expr.toString();
    }
}
