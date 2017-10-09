package Lexer;

/**
 * 异常处理机制
 */
public class ExceptionHandle {

    //Num词法单元异常
    public static void numException(){

    }

    //标识符异常
    public static void identifierException(){
        System.out.println();
        System.out.println("[EXCEPTION: THE IDENTIFIER CANNOT BE RECOGNIZED.]");
        System.out.println("[HINT: THE RECOGNIZABLE IDENTIFIER BEGINS WITH A LETTER AND CANNOT END WITH \"_\".]");
        System.out.println();
    }

    //未定义的符号
    public static void unknownSymbolException(String s){
        System.out.println();
        System.out.println("[EXCEPTION: THE SYMBOL \"" + s + "\" CANNOT BE RECOGNIZED.]");
        System.out.println();
    }

    //符号异常
    public static void symbolException(){

    }

    //其他异常
    public static void otherException(){

    }
}
