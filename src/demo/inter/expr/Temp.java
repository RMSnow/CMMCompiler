package demo.inter.expr;

import demo.lexer.Word;
import demo.symbols.Type;

/**
 * 临时名字
 */
public class Temp extends Expr {
    static int count = 0;
    int number = 0;

    public Temp(Type p) {
        super(Word.temp, p);
        number = ++count;
    }

    public String toString() {
        return "t" + number;
    }
}
