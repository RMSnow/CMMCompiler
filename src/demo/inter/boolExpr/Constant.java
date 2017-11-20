package demo.inter.boolExpr;

import demo.inter.expr.Expr;
import demo.lexer.Num;
import demo.lexer.Token;
import demo.lexer.Word;
import demo.symbols.Type;

/**
 * 创造常量对象
 */
public class Constant extends Expr {

    public static final Constant
            True = new Constant(Word.True, Type.Bool),
            False = new Constant(Word.False, Type.Bool);

    public Constant(Token tok, Type p) {
        super(tok, p);
    }

    public Constant(int i) {     //为一个整数创建常量对象
        super(new Num(i), Type.Int);
    }

    @Override
    public void jumping(int t, int f) {
        if (this == True && t != 0) {
            emit("goto L" + t);
        } else if (this == False && f != 0) {
            emit("goto L" + f);
        }
    }
}
