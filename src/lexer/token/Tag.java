package lexer.token;

/**
 * 词法单元对象的类型
 */
public class Tag {
    public final static int NUM = 256;

    public final static int KEYWORD = 257;

    public final static int IDENTIFIER = 258;

    public final static int BINARY_OPERATOR = 259;

    public final static int ANNOTATION = 260;

    public final static int REAL_NUM = 261;

    public final static int END = 262;

    //为保留字单独添加tag
//    public final static int IF = 263;
//    public final static int ELSE = 264;
//    public final static int WHILE = 265;
//    public final static int READ = 266;
//    public final static int WRITE = 267;
//    public final static int INT = 268;
//    public final static int REAL = 269;



}
