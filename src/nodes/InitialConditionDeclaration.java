package nodes;

import enums.InitConditionType;

public class InitialConditionDeclaration extends InitialCondition{
    public InitConditionType type;
    public Expression value;

    public InitialConditionDeclaration(InitConditionType type, String id, Expression value){
        super(id);
        this.type = type;
        this.value = value;

    }

    @Override
    public String toString() {
        return type.toString() + id + '=' + value.toString();
    }
}
