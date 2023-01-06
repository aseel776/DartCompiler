package nodes;

public class ForStatement extends Statement{
    public InitialCondition initialCondition;
    public Condition stopCondition;
    public Increment increment;
    public Block block;

    public ForStatement(InitialCondition initialCondition, Condition stopCondition, Increment increment, Block block){
        this.initialCondition = initialCondition;
        this.stopCondition = stopCondition;
        this.increment = increment;
        this.block = block;
    }

    @Override
    public String toString() {
        return "for" + '('
                + initialCondition.toString() + ';'
                + stopCondition.toString() + ';'
                + increment.toString() + ')'
                + '\n' + block.toString()
                ;
    }
}
