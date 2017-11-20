package demo.inter.expr;

import demo.lexer.Word;
import demo.symbols.Type;

/**
 * 标识符
 */
public class Id extends Expr {
    public int offset;      //相对地址

    public Id(Word id, Type p, int b) {
        super(id, p);
        offset = b;
    }
}
