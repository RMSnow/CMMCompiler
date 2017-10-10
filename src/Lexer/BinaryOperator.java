package Lexer;

/**
 * 二目符号
 */
public class BinaryOperator extends Token {
    public final String operator;

    public BinaryOperator(String s) {
        super(Tag.BINARY_OPERATOR);
        operator = s;
    }
}
