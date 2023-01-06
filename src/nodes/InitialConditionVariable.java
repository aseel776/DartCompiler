package nodes;

public class InitialConditionVariable extends InitialCondition{

    public InitialConditionVariable(String id){
        super(id);
    }

    @Override
    public String toString() {
        return id;
    }
}
