package v2.inter.expr;

import v2.lexer.Token;
import v2.symbols.Type;
import v3.parser.Parser;

/**
 * 运算符基类，包括算术运算符的子类Arith、单目运算符的子类Unary和数组访问的子类Access
 */
public class Op extends Expr{
    public Op(Token op, Type type) {
        super(op, type);
    }

    @Override
    public Expr reduce() {
        Expr x = gen();
        Temp t = new Temp(type);
        emit(t.toString() + " = " + x.toString());
        return t;
    }

    @Override
    //临时变量不输出行号
    public void emit(String s){
        Parser.out.printf("\t" + s);
        Parser.out.println();
    }
}
