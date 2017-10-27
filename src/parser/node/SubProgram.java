package parser.node;

/**
 * 字程序结点
 */
public class SubProgram extends Node{
    //SubProgram -> Stmt
    //           -> Block

    public Stmt stmt;
    public Block block;

    public SubProgram(Stmt stmt){
        this.stmt = stmt;
    }

    public SubProgram(Block block){
        this.block = block;
    }

}
