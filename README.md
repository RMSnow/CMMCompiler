# CMMParser

## javaCC

## lexer
总体方向：状态转换图实现 => 有穷自动机实现 

未解决的问题：注释嵌套/*/**/

## parser

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

SubProgram -> Stmt
           -> Block

------------------语句与块------------------

Stmt    -> VarDecl
        -> AssignStmt
        -> IfStmt
        -> WhileStmt
        -> ReadStmt
        -> WriteStmt

Block   -> { SubProgram }

------------------变量声明------------------

VarDecl -> Type VarList ;

Type    -> int
        -> real
        -> int[]
        -> real[]

VarList -> ident OtherIdent

OtherIdent  -> , ident OtherIdent
            -> [null]

------------------赋值语句------------------

AssignStmt  -> ident = Expr ;

------------------选择语句------------------

IfStmt      -> if ( Cdt ) Block OtherIfStmt

OtherIfStmt  -> ElseIfStmt
             -> ElseIfStmt ElseStmt
             -> [null]

ElseIfStmt  -> else if ( Cdt ) Block ElseIfStmt
            -> [null]

ElseStmt    -> else Block ElseStmt
            -> [null]

------------------循环语句------------------

WhileStmt   -> ( Cdt ) Block

------------------输入输出------------------

ReadStmt    -> read ( Expr ) ;

WriteStmt   -> write ( Expr ) ;

--------------------条件--------------------

Cdt     -> Expr < Expr
        -> Expr > Expr
        -> Expr == Expr
        -> Expr <= Expr
        -> Expr >= Expr
        -> Expr <> Expr

--------------------表达式-------------------

Expr    -> Term OtherTerm

OtherTerm   -> + Term OtherTerm
            -> - Term OtherTerm
            -> [null]

Term    -> Factor OtherFactor

OtherFactor -> * Factor OtherFactor
            -> / Factor OtherFactor
            -> [null]

Factor  -> ident
        -> ident [ Expr ]
        -> ( Expr )


------------------其他说明------------------

CMM语言说明：

（1）变量的声明与赋值，必须分离

（2）read与write语句使用方法：
    read(a);
    write(b);

（3）IfStmt

--------------------------------------------------------------------------------