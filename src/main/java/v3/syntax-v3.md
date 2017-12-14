## syntax

------------------------------------------
## toImpl

1. 标识符（由数字、字母和下划线组成的串，但必须以字母开头、且不能以下划线结尾的串）

2. ElseStmt
    现只支持：（1）纯if（2）if-else

3. DeclStmt -> Type VarList ;
    VarList 现只支持一个变量

4. 思考与数组有关的
    （1）多维数组（2）数组越界无法检测（3）数组下表为负数，无法检测（4）总有个 *8的偏移量


------------------程序入口------------------

一个程序由一个块组成，该块中包含可选的声明和语句。语法符号basic表示基本类型。  

    Program -> Stmts
    
    Stmts -> Stmts Stmt
           | null
    
    Stmt -> Block
          | DeclStmt
          | AssignStmt
          | IfStmt
          | WhileStmt
          | DoWhileStmt
          | BreakStmt
          | ReadStmt
          | WriteStmt
          
    Block -> { Stmts }

------------------变量声明------------------

    DeclStmt -> Type VarList ;
    
    Type -> Type \[ num ]
          | basic
    
    VarList -> ident OtherIdent
    
    OtherIdent -> , ident OtherIdent
                | null

------------------赋值语句------------------

    AssignStmt -> ident = Bool ;
                | ident \[ Bool ] = Bool ;

------------------条件语句------------------

    IfStmt      -> if ( Bool ) Block OtherIfStmt
    
    OtherIfStmt  -> ElseIfStmt
                 | ElseIfStmt ElseStmt
                 | null
    
    ElseIfStmt  -> else if ( Bool ) Block ElseIfStmt
                | null
    
    ElseStmt    -> else Block
                | null

------------------循环语句------------------

    WhileStmt -> while ( Bool ) Stmt
    
    DoWhileStmt -> do Stmt while ( Bool )
    
    BreakStmt -> break ;

------------------输入输出------------------        //--------------先略过

    ReadStmt    -> read ( Expr ) ;
    
    WriteStmt   -> write ( Expr ) ;

--------------------布尔语句与表达式--------------------

表达式的产生式处理了运算符的结合性和优先级。
它们对每个优先级级别都使用了一个非终结符号，
而非终结符号factor用来表示括号中的表达式、标识符、数组引用和常量。  

    Bool -> Bool || Join
          | Join
    
    Join -> Join && Equality
          | Equality
    
    Equality -> Equality == Rel
              | Equality != Rel
              | Rel
    
    Rel -> Expr < Expr
         | Expr <= Expr
         | Expr > Expr
         | Expr >= Expr
         | Expr
    
    Expr -> Expr + Term
          | Expr - Term
          | Term
             
    Term -> Term * Unary
          | Term / Unary
          | Unary
    
    Unary -> ! Unary
           | - Unary
           | Factor
    
    Factor -> ( Bool )
            | ident
            | ident \[ Bool ]
            | num
            | real
            | true      //????????????????
            | false


















