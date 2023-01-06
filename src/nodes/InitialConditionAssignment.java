package nodes;

public class InitialConditionAssignment extends InitialCondition{
    public Expression value;

    public InitialConditionAssignment(String id, Expression value){
        super(id);
        this.value = value;
    }

    @Override
    public String toString() {
        return id + '=' + value.toString();
    }
}
