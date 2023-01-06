package nodes;

import enums.VarOrType;

public class NamedArgument extends Argument{
    public Boolean isRequired;

    public NamedArgument(VarOrType type, String id, Boolean isRequired){
        super(type, id);
        this.isRequired = isRequired;
    }

    @Override
    public String toString() {
        if(isRequired){
            return "required" + " " + type.toString() + " " + id;
        }else {
            return type.toString() + " " + id;
        }
    }
}
