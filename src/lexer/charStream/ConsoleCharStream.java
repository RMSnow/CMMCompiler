package lexer.charStream;

import java.io.IOException;

public class ConsoleCharStream extends CharStream {
    /**
     * 控制台读取字符
     *
     * @return
     * @throws IOException
     */
    @Override
    public int readChar() throws IOException {
        return System.in.read();
    }
}
