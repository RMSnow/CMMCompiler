package v1.lexer;

/**
 * 异常处理机制
 */
public class LexerException {

    /**
     * 标识符异常
     */
    public static void identifierException() {
        System.out.println();
        System.out.println("[EXCEPTION IN LINE " + LexerEntry.lexer.line + ": THE IDENTIFIER CANNOT BE RECOGNIZED.]");
        System.out.println("[HINT: THE RECOGNIZABLE IDENTIFIER BEGINS WITH A LETTER AND CANNOT END WITH \"_\".]");
        System.out.println();
    }

    /**
     * 未定义的符号
     *
     * @param s
     */
    public static void unknownSymbolException(String s) {
        System.out.println();
        System.out.println("[EXCEPTION IN LINE " + LexerEntry.lexer.line + ": THE SYMBOL \"" + s + "\" CANNOT BE RECOGNIZED.]");
        System.out.println();
    }

    /**
     * 未闭合的多行注释
     */
    public static void unclosedMultiAnnotation() {
        System.out.println();
        System.out.println("[EXCEPTION IN LINE " + LexerEntry.lexer.line + ": \"*/\" IS EXPECTED IN THE FILE.]");
        System.out.println();
    }
}