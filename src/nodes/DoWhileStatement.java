package nodes;

public class DoWhileStatement extends WhileStatement{

    public DoWhileStatement(Condition condition, Block block){
        super(condition, block);
    }

    @Override
    public String toString() {
        return "do" + '\n' + block.toString() + "while" + '(' + condition.toString() + ");" ;
    }
}
