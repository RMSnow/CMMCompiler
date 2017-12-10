package v2.symbols;

import v2.lexer.Tag;

/**
 * 数组类型
 */
public class Array extends Type {
    public Type type;     //数组的元素类型
    public int size = 1;        //元素个数

    public Array(int sz, Type p) {
        super("[]", Tag.INDEX, sz * p.width);
        size = sz;
        type = p;
    }

    public String toString() {
        return "[" + size + "]" + type.toString();
    }

}
