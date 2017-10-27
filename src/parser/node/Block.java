package parser.node;

/**
 *  块结点
 */
public class Block {
    //Block   -> { SubProgram }

    public SubProgram subProgram;

    public Block(SubProgram subProgram){
        this.subProgram = subProgram;
    }
}
