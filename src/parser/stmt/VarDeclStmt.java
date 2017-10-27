package parser.stmt;

import parser.node.Stmt;

/**
 * 声明语句
 *
 * VarDecl -> Type VarList ;
 *
 * Type    -> int
 *         -> real
 *         //暂时不处理下面两个-----------------
 *         -> int[]
 *         -> real[]
 *
 * VarList -> ident OtherIdent
 *
 * OtherIdent  -> , ident OtherIdent
 *             -> [null]
 *
 */

public class VarDeclStmt extends Stmt {
    public String type;
    public Stmt varList;

    public VarDeclStmt(String type, Stmt varList){
        this.type = type;
        this.varList = varList;
    }

    //undefined
    @Override
    public void printSyntaxTree(){
        System.out.println("--------------------");
        System.out.println("VarDecl");
        System.out.println("-> Type VarList ;");
        System.out.println("-> "+type+" VarList ;");
        System.out.println("-> "+type+" ");
        System.out.println("--------------------");
    }

}
