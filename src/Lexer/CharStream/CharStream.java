package Lexer.CharStream;

import Lexer.Lexer;

import java.io.File;
import java.io.IOException;

/**
 * 读取字符接口
 */
public interface CharStream {
    public int readChar(File file) throws IOException;
}
