package Lexer;

/**
 * Created by snow on 09/10/2017.
 */
public class BinaryOperator extends Token{
    public final String operator;

    public BinaryOperator(int t, String s){
        super(t);
        operator = s;
    }
}
