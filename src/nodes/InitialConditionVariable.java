package nodes;

public class InitialConditionVariable extends InitialCondition{
    public Variable id;

    public InitialConditionVariable(Variable id){
        this.id = id;
    }

    @Override
    public String toString() {
        return id.toString();
    }
}
