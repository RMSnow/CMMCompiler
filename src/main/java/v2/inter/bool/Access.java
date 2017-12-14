package v2.inter.bool;

import v2.inter.expr.Expr;
import v2.inter.expr.Id;
import v2.inter.expr.Op;
import v2.lexer.Tag;
import v2.lexer.Word;
import v2.symbols.Type;

/**
 * 数组访问: Id[Expr]
 */
public class Access extends Op{
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
