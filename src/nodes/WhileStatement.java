package nodes;

public class WhileStatement extends Statement{

    public Condition condition;
    public Block block;

    public WhileStatement(Condition condition, Block block){
        this.condition = condition;
        this.block = block;
    }

    @Override
    public String toString() {
        return "while" + '(' + condition.toString() + ')' + '\n' + block.toString();
    }
}
