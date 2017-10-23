package lexer.CharStream;

import java.io.*;

public class FileCharStream extends CharStream {
    private Reader reader;

    /**
     * 构造函数
     *
     * @param filename
     * @throws FileNotFoundException
     */
    public FileCharStream(String filename) throws FileNotFoundException {
        File file = new File(filename);
        reader = new InputStreamReader(new FileInputStream(file));
    }

    /**
     * 文件读取字符
     *
     * @return
     * @throws IOException
     */
    @Override
    public int readChar() throws IOException {
        return reader.read();
    }
}
