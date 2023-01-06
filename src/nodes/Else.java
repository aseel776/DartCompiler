package nodes;

public class Else extends Node{
    public Block block;

    public Else(Block block){
        this.block = block;
    }

    @Override
    public String toString() {
        return "else" + '\n' + block.toString();
    }
}
