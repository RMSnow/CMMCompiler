package v3.parser;

import v2.inter.Node;
import v2.inter.bool.*;
import v2.inter.expr.*;
import v2.inter.stmt.*;
import v2.lexer.*;
import v2.symbols.Array;
import v2.symbols.Env;
import v2.symbols.Type;
import v3.Conf;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 语法分析器-v3：更改了v2的部分语法
 */
public class Parser {
    Env top = null;     // 当前或顶层的符号表
    int used = 0;       // 用于变量声明的存储位置
    private Lexer lex;      // 词法分析器
    private Token look;     // 向前看词法单元

    public static PrintWriter out;      //输出至文件

    public Parser(Lexer l) throws IOException {
        //静态变量初始化
        Lexer.line = 1;
        Node.labels = 0;
        Temp.count = 0;

        out = new PrintWriter(Conf.interFile);

        lex = l;
        move();
    }

    void move() throws IOException {
        look = lex.scan();
    }

    void error(String s) {
        throw new Error("near line " + lex.line + ": " + s);
    }

    void match(int t) throws IOException {
        if (look.tag == t) {
            move();
        } else {
            error("syntax error");
        }
    }

    /**
     * 语法分析的入口: Program -> Stmts
     */
    public void program() throws IOException {
        top = new Env(top);
        Stmt s = stmts();

        //生成三地址码，并输出至文件
        int begin = s.newlabel();
        int after = s.newlabel();
        s.emitlabel(begin);
        s.gen(begin, after);
        s.emitlabel(after);

        out.flush();
    }

    /**
     * Stmts -> Stmts Stmt | null
     *
     * @return
     * @throws IOException
     */
    Stmt stmts() throws IOException {
        switch (look.tag) {
            case '{':
            case Tag.BASIC:
            case Tag.ID:
            case Tag.IF:
            case Tag.WHILE:
            case Tag.DO:
            case Tag.BREAK:
                //TODO: read & write
                return new Seq(stmt(), stmts());
            default:
                return Stmt.Null;
        }
    }

    /**
     * Stmt -> Block
     * | DeclStmt
     * | AssignStmt-----------
     * | IfStmt
     * | WhileStmt
     * | DoWhileStmt
     * | BreakStmt
     * | ReadStmt
     * | WriteStmt
     *
     * @return
     * @throws IOException
     */
    Stmt stmt() throws IOException {
        Expr x;
        Stmt s, s1, s2;
        Stmt savedStmt;     // 用于为break语句保存外层的循环语句

        switch (look.tag) {
            //------------------------
            case ';':
                move();
                return Stmt.Null;
            //------------------------

            case '{':       //Block
                return block();
            case Tag.BASIC:     //DeclStmt
                return decl();
            case Tag.ID:        //AssignStmt
                return assign();
            case Tag.IF:        //IfStmt
                match(Tag.IF);
                match('(');
                x = bool();
                match(')');

                s1 = stmt();
                if (look.tag != Tag.ELSE) {
                    return new If(x, s1);
                }

                match(Tag.ELSE);
                s2 = stmt();
                return new Else(x, s1, s2);
            case Tag.WHILE:     //WhileStmt
                While whilenode = new While();
                savedStmt = Stmt.Enclosing;     //-----------------------------
                Stmt.Enclosing = whilenode;

                match(Tag.WHILE);
                match('(');
                x = bool();
                match(')');

                s1 = stmt();
                whilenode.init(x, s1);
                Stmt.Enclosing = savedStmt;     // 重置Stmt.Enclosing
                return whilenode;
            case Tag.DO:        //DoStmt
                Do donode = new Do();
                savedStmt = Stmt.Enclosing;
                Stmt.Enclosing = donode;

                match(Tag.DO);
                s1 = stmt();
                match(Tag.WHILE);
                match('(');
                x = bool();
                match(')');
                match(';');

                donode.init(s1, x);
                Stmt.Enclosing = savedStmt;     // 重置Stmt.Enclosing
                return donode;
            case Tag.BREAK:     //BreakStmt
                match(Tag.BREAK);
                match(';');
                return new Break();

            //TODO: read() & write()

            //------------------------
            default:
                return null;
        }
    }

    /**
     * Block -> { Stmts }
     *
     * @return
     * @throws IOException
     */
    Stmt block() throws IOException {
        match('{');

        //新建符号表结点
        Env savedEnv = top;
        top = new Env(top);

        Stmt s = stmts();

        match('}');

        //删除符号表结点
        top = savedEnv;

        return s;
    }

    /**
     * DeclStmt -> Type VarList ; (目前VarList -> ident)
     *
     * @throws IOException
     */
    Stmt decl() throws IOException {
        Type p = type();
        Token tok = look;
        match(Tag.ID);
        match(';');

        //向符号表中添加信息
        Id id = new Id((Word) tok, p, used);
        top.put(tok, id);
        used = used + p.width;

        return Stmt.Null;
    }

    /**
     * Type -> Type [ num ] | basic
     *
     * @return
     * @throws IOException
     */
    Type type() throws IOException {
        Type p = (Type) look;
        match(Tag.BASIC);
        if (look.tag != '[') {
            return p;
        } else {
            return dims(p);     // 返回数组类型
        }
    }

    /**
     * 数组类型, eg: int[5] a;
     *
     * @param p
     * @return
     * @throws IOException
     */
    Type dims(Type p) throws IOException {
        match('[');
        Token tok = look;
        match(Tag.NUM);
        match(']');

        if (look.tag == '[') {
            p = dims(p);
        }

        return new Array(((Num) tok).value, p);     //多维数组------------
    }

    /**
     * AssignStmt -> ident = Bool ;
     * | ident [ Bool ] = Bool ;
     *
     * @return
     * @throws IOException
     */
    Stmt assign() throws IOException {
        Stmt stmt;
        Token t = look;
        match(Tag.ID);
        Id id = top.get(t);

        if (id == null) {
            error(t.toString() + " undeclared");
        }

        if (look.tag == '=') {
            move();
            stmt = new Set(id, bool());
        } else {        //数组类型
            Access x = offset(id);
            match('=');
            stmt = new SetElem(x, bool());
        }

        match(';');
        return stmt;
    }

    /**
     * Bool -> Bool || Join | Join
     *
     * @return
     * @throws IOException
     */
    Expr bool() throws IOException {
        Expr x = join();
        while (look.tag == Tag.OR) {
            Token tok = look;
            move();
            x = new Or(tok, x, join());
        }
        return x;
    }

    /**
     * Join -> Join && Equality | Equality
     *
     * @return
     * @throws IOException
     */
    Expr join() throws IOException {
        Expr x = equality();
        while (look.tag == Tag.AND) {
            Token tok = look;
            move();
            x = new And(tok, x, equality());
        }
        return x;
    }

    /**
     * Equality -> Equality == Rel
     * | Equality != Rel
     * | Rel
     *
     * @return
     * @throws IOException
     */
    Expr equality() throws IOException {
        Expr x = rel();
        while (look.tag == Tag.EQ || look.tag == Tag.NE) {
            Token tok = look;
            move();
            x = new Rel(tok, x, rel());
        }
        return x;
    }

    /**
     * Rel -> Expr < Expr
     * | Expr <= Expr
     * | Expr > Expr
     * | Expr >= Expr
     * | Expr
     *
     * @return
     * @throws IOException
     */
    Expr rel() throws IOException {
        Expr x = expr();
        switch (look.tag) {
            case '<':
            case '>':
            case Tag.LE:
            case Tag.GE:
                Token tok = look;
                move();
                return new Rel(tok, x, expr());
            default:
                return x;
        }
    }

    /**
     * Expr -> Expr + Term
     * | Expr - Term
     * | Term
     *
     * @return
     * @throws IOException
     */
    Expr expr() throws IOException {
        Expr x = term();
        while (look.tag == '+' || look.tag == '-') {
            Token tok = look;
            move();
            x = new Arith(tok, x, term());
        }
        return x;
    }

    /**
     * Term -> Term * Unary
     * | Term / Unary
     * | Unary
     *
     * @return
     * @throws IOException
     */
    Expr term() throws IOException {
        Expr x = unary();
        while (look.tag == '*' || look.tag == '/') {
            Token tok = look;
            move();
            x = new Arith(tok, x, unary());
        }
        return x;
    }

    /**
     * Unary -> ! Unary
     * | - Unary
     * | Factor
     *
     * @return
     * @throws IOException
     */
    Expr unary() throws IOException {
        if (look.tag == '-') {
            move();
            return new Unary(Word.minus, unary());
        } else if (look.tag == '!') {
            Token tok = look;
            move();
            return new Not(tok, unary());
        } else {
            return factor();
        }
    }

    /**
     * Factor -> ( Bool )
     * | ident
     * | ident [ Bool ]
     * | num
     * | real
     * | true
     * | false
     *
     * @return
     * @throws IOException
     */
    Expr factor() throws IOException {
        Expr x = null;
        switch (look.tag) {
            case '(':
                move();
                x = bool();
                match(')');
                return x;

            case Tag.NUM:
                x = new Constant(look, Type.Int);
                move();
                return x;

            case Tag.REAL:
                x = new Constant(look, Type.Float);
                move();
                return x;

            case Tag.TRUE:
                x = Constant.True;
                move();
                return x;

            case Tag.FALSE:
                x = Constant.False;
                move();
                return x;

            case Tag.ID:
                String s = look.toString();
                Id id = top.get(look);

                if (id == null) {
                    error(look.toString() + " undeclared");
                }

                move();
                if (look.tag != '[') {
                    return id;
                } else {
                    return offset(id);
                }

            default:
                error("syntax error");
                return x;
        }
    }

    /**
     * 数组作为因子：array[element]
     *
     * @param arrayIdent
     * @return
     * @throws IOException
     */
    Access offset(Id arrayIdent) throws IOException {
        Array arrayType = (Array) arrayIdent.type;       //数组类型

        match('[');
        Expr offsetExpr = bool();
        match(']');

        Type accessType = ((Array) arrayType).type;     //访问类型，必须为整型
        if (offsetExpr.type != Type.Int) {
            error("The offset of array must be Int.");
        }
        //TODO: 数据访问越界-涉及到取值：这是代码生成阶段。

        return new Access(arrayIdent, offsetExpr, accessType);

//        w = new Constant(elementType.width);
//        t1 = new Arith(new Token('*'), i, w);
//        loc = t1;

        //TODO: 多维数组
//        while (look.tag == '[') {        // 多维下标, I -> [E]I
//            match('[');
//            i = bool();
//            match(']');
//
//            elementType = ((Array) elementType).type;
//            w = new Constant(elementType.width);
//            t1 = new Arith(new Token('*'), i, w);
//            t2 = new Arith(new Token('+'), loc, t1);
//            loc = t2;
//        }

//        return new Access(arrayIdent, loc, elementType);


    }
}
