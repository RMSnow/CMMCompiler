package demo.inter.boolExpr;

import demo.inter.expr.Expr;
import demo.inter.expr.Id;
import demo.inter.expr.Op;
import demo.lexer.Tag;
import demo.lexer.Word;
import demo.symbols.Type;

/**
 * 数组访问（源语言允许把布尔值赋给标识符和数组元素，因此布尔表达式有可能是一个数组访问）
 */
public class Access extends Op {
    public Id array;
    public Expr index;

    public Access(Id a, Expr i, Type p) {       //p是将数组平坦化后的元素类型
        super(new Word("[]", Tag.INDEX), p);
        array = a;
        index = i;
    }

    @Override
    public Expr gen() {
        return new Access(array, index.reduce(), type);
    }

    @Override
    public void jumping(int t, int f) {
        emitjumps(reduce().toString(), t, f);
    }

    public String toString() {
        return array.toString() + "[" + index.toString() + "]";
    }
}
