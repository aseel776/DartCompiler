package nodes;

public class InitialConditionAssignment extends InitialConditionVariable{
    public Expression value;

    public InitialConditionAssignment(Variable id, Expression value){
        super(id);
        this.value = value;
    }

    @Override
    public String toString() {
        return id.toString() + '=' + value.toString();
    }
}
