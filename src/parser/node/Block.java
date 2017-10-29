package parser.node;

/**
 * 块结点
 * Block
 * -> { SubProgram }
 */
public class Block extends Node {

    @Override
    public void printNode() {
        super.printNode();
        System.out.println("Block -> { SubProgram }");
    }
}
