package v1.parser.node;

/**
 * 子程序结点
 * <p>
 * SubProgram
 * -> Stmt
 * | Block
 */
public class SubProgram extends Node {
    public Stmt stmt;
    public Block block;

    public static SubProgram Null = null;

    public SubProgram(Stmt stmt) {
        this.stmt = stmt;
        addValue("Stmt");
    }

    public SubProgram(Block block) {
        this.block = block;
        addValue("Block");
    }
}
