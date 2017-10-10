package Lexer.CharStream;

import java.io.File;
import java.io.IOException;

/**
 * 控制台读取字符
 */
public class ConsoleCharStream implements CharStream {
    public int readChar(File file) throws IOException {
        return System.in.read();
    }
}
