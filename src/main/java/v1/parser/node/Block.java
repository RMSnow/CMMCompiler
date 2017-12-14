package v1.parser.node;

/**
 * 块结点
 * <p>
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
