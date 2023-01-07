package nodes;

public class InitialConditionDeclaration extends InitialCondition{
    public String type;
    public String id;
    public Expression value;

    public InitialConditionDeclaration(String type, String id, Expression value){
        this.type = type;
        this.id = id;
        this.value = value;

    }

    @Override
    public String toString() {
        return type + " " + id + '=' + value.toString();
    }
}
