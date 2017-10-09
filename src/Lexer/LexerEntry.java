package Lexer;

import java.io.IOException;

/**
 * 词法分析程序的入口
 */
public class LexerEntry {

    public static void main(String[] args) throws IOException {
        guidance();
        Lexer lexer = new Lexer();

        //键盘输入
        for(int line = 0;;line++){
            Token token = lexer.scan();
            if(token == null){
                System.out.println("ERROR");
                return;
            }

            if(token instanceof Num){
                System.out.printf("<NUM, "+((Num) token).value+"> ");
            }else if(token instanceof Word){
                if(token.tag == Tag.KEYWORD){
                    System.out.printf("<KEYWORD, "+((Word) token).lexeme+"> ");
                }else{
                    System.out.printf("<IDENTIFIER, "+((Word) token).lexeme+"> ");
                }
            }else if(token instanceof BinaryOperator){
                System.out.printf("< "+((BinaryOperator) token).operator+" > ");
            }else{
                System.out.printf("< "+(char)token.tag+" > ");
            }

            if(line == 5){
                System.out.println();
                line=0;
            }
        }


//        char c = '>';
//        String s = String.valueOf(c);
//        c = '=';
//        s += String.valueOf(c);
//        System.out.print(s);

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
1.无浮点数、无注释时
    //（1）各个符号单个输入
    if,else,while,read,write,int,real
    +,-,*,/,=,<,>,==,<=,>=,<>,{,},[,]

    //（2）语句（有空白与无空白）
    int a, b;
    real[] r;
    a = 1;
    read(b);
    r[0] = 0;

    while(a < b){
        if(a == 3){
            r[3] = 3;
        }else if(a >= 5){
            r[5] = 5;
        }else{
            r[7] = (a * 3) - (b / 3);
        }
        a = a + 1;
    }

    write(a, b, r);

    #

    //（3）出错处理
    a. 不正确的标识符，如_a，1a，a1b_
    b. 未知单目符号，如$,@

 */