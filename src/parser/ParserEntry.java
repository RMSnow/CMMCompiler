package parser;

import lexer.Lexer;

import java.io.IOException;

/**
 * 语法分析器的入口
 */
public class ParserEntry {
    public static Parser parser;

    public static void main(String[] args) throws IOException {
        Lexer lexer = new Lexer("Test/Parser.txt");
        parser = new Parser(lexer);
        parser.program();
    }
}
