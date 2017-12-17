package v3.inter;

import v2.symbols.Env;
import v3.Conf;
import v3.parser.Parser;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * 更低层的中间代码（四元式表示）
 */
public class IR {
    private Parser parser;
    private Scanner scanner;

    public static PrintWriter out;      //输出至文件

    public IR(Parser parser) throws IOException {
        this.parser = parser;
        scanner = new Scanner(parser.program());

        out = new PrintWriter(Conf.machineFile);
    }

    public File getVMCode() {
        while (scanner.hasNext()) {
            String tempLine = scanner.nextLine();
            char firstChar = tempLine.charAt(0);

            switch (firstChar){
                case 'L':       //标签
                    out.println(tempLine);
                case 'B':       //新的作用域
//                    parser.tempEnv = parser.tempEnv.next;
                case 'E':       //作用域结束
//                    parser.tempEnv = parser.tempEnv.prev;
                default:        //三地址代码

            }


        }

        out.flush();
        return Conf.machineFile;
    }
}
