package Lexer;

import java.io.IOException;
import java.io.InputStream;

/**
 * 词法分析程序的入口
 */
public class LexerEntry {

    public static void main(String[] args) throws IOException {
        guidance();
        Lexer lexer = new Lexer();

//        for(;;){
//            Token token = lexer.scan();
//            if(token instanceof Num){
//                System.out.printf("<NUM, "+((Num) token).value+"> ");
//            }else if(token instanceof Word){
//                if(token.tag == Tag.KEYWORD){
//                    System.out.printf("<KEYWORD, \""+((Word) token).lexeme+"\"> ");
//                }else{
//                    System.out.printf("<IDENTIFIER, \""+((Word) token).lexeme+"\"> ");
//                }
//            }else{
//                //System.out.printf("<"+(char)token.tag+"> ");
//                //continue;
//            }
//        }

        Token token = lexer.scan();
        if(token == null){
            System.out.println("ERROR");
        }

        if(token instanceof Num){
            System.out.printf("<NUM, "+((Num) token).value+"> ");
        }else if(token instanceof Word){
            if(token.tag == Tag.KEYWORD){
                System.out.printf("<KEYWORD, \""+((Word) token).lexeme+"\"> ");
            }else{
                System.out.printf("<IDENTIFIER, \""+((Word) token).lexeme+"\"> ");
            }
        }else if(token instanceof BinaryOperator){
            System.out.printf("<\""+((BinaryOperator) token).operator+"\"> ");
        }else{
            System.out.printf("<\""+(char)token.tag+"\"> ");
        }


//        String s = ">=";
//        System.out.print(s.length());

//        InputStream in = System.in;
//        int a = in.read();
//        System.out.println(a);
//        a = in.read();
//        System.out.println(a);
//        a = in.read();
//        System.out.println(a);


    }

    //操作说明
    public static void guidance(){
        System.out.println("------------------------使用方法------------------------");
        System.out.println("1.键盘输入：输入命令\"scan #\"后，在键盘输入代码");
        System.out.println("2.读取文件：输入命令\"scan [文件名]\"，如：scan test.txt");
        System.out.println("-------------------------------------------------------");
    }
}

/*
测试用例：
    int a, b;
    real[] r;
    a = 1;
    read(b);
    r[0] = 0;

    while(a < b){
        if(a == 3){
            r[3] = 3;
        }else if(a == 5){
            r[5] = 5;
        }else{
            r[7] = (a * 3) - (b / 3);
        }
        a = a + 1;
    }

    write(a, b, r);

    #
 */