package Lexer;

import Lexer.Token.*;

import java.io.IOException;

/**
 * 词法分析程序的入口
 */
public class LexerEntry {
    public static Lexer lexer;
    public static int tempLine = 0;

    /**
     * 程序入口，需指定命令行参数
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        guidance();

        if (args.length != 2 || (args[0].equals("scan") != true)) {
            System.out.println("INVALID USAGE.");
            return;
        }

        if (args[1].equals("#")) {
            lexer = new Lexer();        //键盘输入
        } else {
            lexer = new Lexer(args[1]);     //文件输入
        }

        for (; ; ) {
            Token token = lexer.scan();

            if (token == null) {
                return;
            }

            if (token.tag == Tag.ANNOTATION)
                continue;

            if (token.tag == Tag.END) {
                System.out.println();
                System.out.println();
                System.out.println("Has finished the lexical analysis successfully!");
                return;
            }

            if (args[1].equals("#")) {
                keyboardOutput(token);      //键盘输入时的输出
            } else {
                fileOutput(token);      //文件输入时的输出
            }
        }
    }

    /**
     * 操作说明
     */
    public static void guidance() {
        System.out.println("------------------------使用方法------------------------");
        System.out.println("1.键盘输入：输入命令\"scan #\"后，在键盘输入代码，\"#\"为输入结束符");
        System.out.println("2.读取文件：输入命令\"scan [文件名]\"，如：scan test.txt");
        System.out.println("-------------------------------------------------------");
    }

    /**
     * 键盘输入时的解析结果
     *
     * @param token
     */
    public static void keyboardOutput(Token token) {
        if (token instanceof Num) {
            System.out.printf("<NUM, " + ((Num) token).value + "> ");
        } else if (token instanceof RealNum) {
            System.out.printf("<REAL_NUM, " + ((RealNum) token).number.value
                    + "." + ((RealNum) token).fraction.value + "> ");
        } else if (token instanceof Word) {
            if (token.tag == Tag.KEYWORD) {
                System.out.printf("<KEYWORD, " + ((Word) token).lexeme + "> ");
            } else {
                System.out.printf("<IDENTIFIER, " + ((Word) token).lexeme + "> ");
            }
        } else if (token instanceof BinaryOperator) {
            System.out.printf("< " + ((BinaryOperator) token).operator + " > ");
        } else {
            System.out.printf("< " + (char) token.tag + " > ");
        }
    }

    /**
     * 文件输入时的解析结果
     *
     * @param token
     */
    public static void fileOutput(Token token) {
        if (tempLine != lexer.line) {
            System.out.println();
            System.out.printf("[Line " + lexer.line + "] ");
            tempLine = lexer.line;
        }
        keyboardOutput(token);
    }
}