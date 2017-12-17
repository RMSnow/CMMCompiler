package v2.inter.bool;

import v2.inter.expr.Expr;
import v2.inter.expr.Op;
import v2.inter.expr.Temp;
import v2.lexer.Token;
import v2.symbols.Type;
import v3.parser.Parser;

/**
 * 逻辑运算符基类: expr1 Logical expr2
 */
public class Logical extends Op{
    Expr expr1, expr2;

    public Logical(Token op, Expr expr1, Expr expr2){
        super(op, null);
        this.expr1 = expr1;
        this.expr2 = expr2;

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
        super.recordLineNum();

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

    @Override
    //临时变量不输出行号
    public void emit(String s){
        Parser.out.printf("\t" + s);
        Parser.out.println();
    }
}
