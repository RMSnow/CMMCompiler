# CMMParser

## javaCC

## lexer
总体方向：状态转换图实现 => 有穷自动机实现 

未解决的问题：   

（1）注释嵌套/*/**/
（2）与parser有关的：是否要把int[]、real[]处理成一个Token
（3）文档末有单行注释时，会产生错误的死循环

## parser

未解决的问题：
（1）有关注释
（2）有关数组[]
（3）if-else语句的ElseStmt
（4）出错处理

--------------------------------------------------------------------------------

总体方向：递归下降 => LL的预测表法 => LR分析方法

过程：
（1）定义CMM语法（BNF/语法描述图）
（2）明确输入、输出、测试用例
（3）编写递归下降子程序法

--------------------------------------------------------------------------------

实操：

（1）CMM语言文法描述：

------------------程序入口------------------

Program -> SubProgram

SubProgram -> Stmt SubProgram
           | Block SubProgram
           | [EOF]

------------------语句与块------------------

Stmt    -> VarDecl
        | AssignStmt
        | IfStmt
        | WhileStmt
        | ReadStmt
        | WriteStmt

Block   -> { SubProgram }

------------------变量声明------------------

VarDecl -> Type VarList ;

Type    -> int
        | real
        | int[]
        | real[]

VarList -> ident OtherIdent

OtherIdent  -> , ident OtherIdent
            | [null]

------------------赋值语句------------------

AssignStmt  -> ident = Expr ;
            | ident [ Expr ] = Expr ;

------------------选择语句------------------

IfStmt      -> if ( Cdt ) Block OtherIfStmt

OtherIfStmt  -> ElseIfStmt
             | ElseIfStmt ElseStmt
             | [null]

ElseIfStmt  -> else if ( Cdt ) Block ElseIfStmt
            | [null]

ElseStmt    -> else Block
            | [null]

------------------循环语句------------------

WhileStmt   -> while ( Cdt ) Block

------------------输入输出------------------

ReadStmt    -> read ( Expr ) ;

WriteStmt   -> write ( Expr ) ;

--------------------条件--------------------

Cdt     -> Expr < Expr
        | Expr > Expr
        | Expr == Expr
        | Expr <= Expr
        | Expr >= Expr
        | Expr <> Expr

--------------------表达式-------------------

Expr    -> Term OtherTerm

OtherTerm   -> + Term OtherTerm
            | - Term OtherTerm
            | [null]

Term    -> Factor OtherFactor

OtherFactor -> * Factor OtherFactor
            | / Factor OtherFactor
            | [null]

Factor  -> ident
        | ident [ Expr ]
        | [Num]
        | ( Expr )


------------------其他说明------------------

CMM语言说明：

（1）变量的声明与赋值，必须分离

（2）read与write语句使用方法：
    read(a);
    write(b);

（3）把选择语句化为LL(0)文法：

IfStmt      -> if ( Cdt ) Block OtherIfStmt

OtherIfStmt  -> ElseIfStmt
             | ElseIfStmt ElseStmt
             | [null]

ElseIfStmt  -> else if ( Cdt ) Block ElseIfStmt
            | [null]

ElseStmt    -> else Block
            | [null]
            

转化后为：

IfStmt          -> if ( Cdt ) { SubProgram } OtherIfStmt

OtherIfStmt     -> else OtherIfStmt1
                 | [null]

OtherIfStmt1    -> { SubProgram }
                 | if ( Cdt ) { SubProgram } ElseIfStmt ElseStmt                
                 
ElseIfStmt      -> else if ( Cdt ) { SubProgram } ElseIfStmt
                 | [null]

ElseStmt        -> else { SubProgram }
                 | [null]
                 
--------------------------------------------------------------------------------

（2）输入、输出、测试用例

【输入】    CMM源文件

【输出】    语法树／其他形式
（1）每一条语句对应一个语法树
（2）输出语法树的"颗粒度"：VarDecl，AssignStmt，IfStmt，WhileStmt，ReadStmt，WriteStmt
（3）输出形式：源文件中语句所在行号 + 语法树说明 

表达式结点  +  语句结点


【测试用例】
可先用Lexer.txt


--------------------------------------------------------------------------------
整理基础内容：

（1）子类无法转父类

（2）值传递与地址传递

（3）子类与父类：构造函数的调用顺序








