package parser.node;

/**
 * 块结点
 */
public class Block extends Node {
    //Block   -> { SubProgram }

//    public SubProgram subProgram;
//
//    public Block() {
//
//    }
//
//    public Block(SubProgram subProgram) {
//        this.subProgram = subProgram;
//        addValue("{ SubProgram }");
//    }

    @Override
    public void printNode() {
        super.printNode();
        System.out.println("Block -> { SubProgram }");
    }
}
