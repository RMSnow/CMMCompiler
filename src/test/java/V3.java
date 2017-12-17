import v2.lexer.Lexer;
import v3.Conf;
import v3.inter.IR;
import v3.parser.Parser;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by snow on 14/12/2017.
 */
public class V3 {
    public static void main(String[] args) throws IOException {
        Lexer lexer = new Lexer();
        Parser parser = new Parser(lexer);
        IR inter = new IR(parser);

        Scanner scanner = new Scanner(inter.getVMCode());
        while (scanner.hasNext()){
            System.out.println(scanner.nextLine());
        }

    }
}
