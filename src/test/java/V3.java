import v2.lexer.Lexer;
import v3.parser.Parser;

import java.io.IOException;

/**
 * Created by snow on 14/12/2017.
 */
public class V3 {
    /**
     * main创建了一个词法分析器和一个语法分析器，然后调用语法分析器中的方法program
     *
     * @param args
     */
    public static void main(String[] args) throws IOException {
        Lexer lexer = new Lexer();
        //设置从命令行读入
        lexer.isScanFromGUI = false;

        Parser parser = new Parser(lexer);
        parser.program();
    }
}
