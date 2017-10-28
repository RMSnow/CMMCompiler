package parser.node;

/**
 * 字程序结点
 */
public class SubProgram extends Node {
    //SubProgram -> Stmt
    //           -> Block

    public Stmt stmt;
    public Block block;

    public SubProgram(Stmt stmt) {
        this.stmt = stmt;
        addValue("Stmt");
    }

    public SubProgram(Block block) {
        this.block = block;
        addValue("Block");
    }


//    @Override
//    public void printNode() {
//        if (this.startLine != this.endLine) {
//            System.out.printf("[Line " + this.startLine + "-" + this.endLine + "] ");
//        } else {
//            System.out.printf("[Line " + this.startLine + "] ");
//        }
//
//        if (this.getValue() == "Stmt") {
//            System.out.println("SubProgram -> Stmt");
//        } else {
//            System.out.println("SubProgram -> Block");
//        }
//    }

}
