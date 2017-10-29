package parser.stmt;

import parser.node.Stmt;

/**
 * 选择语句
 * IfStmt
 * -> if ( Cdt ) Block OtherIfStmt
 * OtherIfStmt  -> ElseIfStmt
 * | ElseIfStmt ElseStmt
 * | [null]
 * ElseIfStmt
 * -> else if ( Cdt ) Block ElseIfStmt
 * | [null]
 * ElseStmt
 * -> else Block ElseStmt
 * | [null]
 */
public class IfStmt extends Stmt {
//    @Override
//    public void printNode(){
//
//    }
}
