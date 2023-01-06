package nodes;

public class ElseIf extends Node{
    public Condition condition;
    public Block block;

    public ElseIf(Condition condition, Block block){
        this.condition = condition;
        this.block = block;
    }

    @Override
    public String toString() {
        return "else if" + '(' + condition.toString() + ')' + '\n' + block.toString();
    }
}
