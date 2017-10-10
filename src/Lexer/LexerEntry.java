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
        for (; ; ) {
            Token token = lexer.scan();

            if (token == null) {
                System.out.println("ERROR");
                return;
            }

            if (token.tag == Tag.ANNOTATION)
                continue;

            if (token.tag == Tag.END) {
                System.out.println("Has finished the lexical analysis successfully!");
                return;
            }

            if (token instanceof Num) {
                System.out.printf("<NUM, " + ((Num) token).value + "> ");
            } else if (token instanceof RealNum) {
                System.out.printf("<REAL_NUM, " + ((RealNum) token).number.value
                        + "." + ((RealNum) token).fraction.value + "> ");
            } else if (token instanceof Word) {
                if (token.tag == Tag.KEYWORD) {
                    System.out.printf("<KEYWORD, " + ((Word) token).lexeme + "> ");
                } else {
                    System.out.printf("<IDENTIFIER, " + ((Word) token).lexeme + "> ");
                }
            } else if (token instanceof BinaryOperator) {
                System.out.printf("< " + ((BinaryOperator) token).operator + " > ");
            } else {
                System.out.printf("< " + (char) token.tag + " > ");
            }
        }
    }

    //操作说明
    public static void guidance() {
        System.out.println("------------------------使用方法------------------------");
        System.out.println("1.键盘输入：输入命令\"scan #\"后，在键盘输入代码");
        System.out.println("2.读取文件：输入命令\"scan [文件名]\"，如：scan test.txt");
        System.out.println("-------------------------------------------------------");
    }
}

/*
关于词法与语法要求：
1. 没有负数
2. 浮点数
（1）[Num].[Num]
（2）.[Num]分析为0.[Num]，但单独的"."则无法识别
（3）[Num].分析为[Num].0
 */

/*
--------------------------------------键盘输入测试用例--------------------------------------

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

2.注释
（1）单行注释
    a. //read(a);
    b. int//double b; a

（2）多行注释
    a. [多行注释]
    b. int[多行注释]a;

3.浮点数
（1）[Num].[Num]
（2）.[Num]分析为0.[Num]
（3）[Num].分析为[Num].0

---------------------------------------------------------------------------------------
*/