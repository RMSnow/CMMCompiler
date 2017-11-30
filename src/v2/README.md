## syntax

------------------程序入口------------------

一个程序由一个块组成，该块中包含可选的声明和语句。语法符号**basic**表示基本类型。  

Program -> Stmts

Stmts -> Stmts Stmt
       | **null**

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

Type -> Type \[ **num** ]       //-----------------Expr?
      | **basic**

VarList -> **ident** OtherIdent

OtherIdent -> , **ident** OtherIdent
            | **null**

------------------赋值语句------------------

AssignStmt -> **ident** = Bool ;
            | **ident** \[ Bool ] = Bool ;

------------------条件语句------------------

IfStmt      -> **if** ( Bool ) Block OtherIfStmt

OtherIfStmt  -> ElseIfStmt
             | ElseIfStmt ElseStmt
             | **null**

ElseIfStmt  -> **else** **if** ( Bool ) Block ElseIfStmt
            | **null**

ElseStmt    -> **else** Block
            | **null**

------------------循环语句------------------

WhileStmt -> **while** ( Bool ) Block

DoWhileStmt -> **do** Block **while** ( Bool )

BreakStmt -> **break** ;

------------------输入输出------------------        //--------------先略过

ReadStmt    -> **read** ( Expr ) ;

WriteStmt   -> **write** ( Expr ) ;

--------------------布尔语句与表达式--------------------

表达式的产生式处理了运算符的结合性和优先级。
它们对每个优先级级别都使用了一个非终结符号，
而非终结符号**factor**用来表示括号中的表达式、标识符、数组引用和常量。  

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
        | **ident**
        | ident \[ Bool ]
        | **num**
        | **real**
        | **true**      //????????????????
        | **false**


















