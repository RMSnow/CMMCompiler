package v2.inter.expr;

import v2.lexer.Word;
import v2.symbols.Type;

/**
 * 标识符
 */
public class Id extends Expr{
    public int offset;      //相对地址????????????????????????

    public Id(Word id, Type type, int offset){
        super(id, type);
        this.offset = offset;
    }
}
