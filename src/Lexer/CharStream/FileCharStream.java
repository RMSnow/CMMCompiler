package Lexer.CharStream;

import java.io.*;

/**
 * 文件读取字符
 */
public class FileCharStream implements CharStream {
    public int readChar(File file) throws IOException{
        Reader reader = new InputStreamReader(new FileInputStream(file));
        return reader.read();
    }
}
