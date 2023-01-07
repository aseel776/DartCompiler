package nodes;

public class NamedArgument extends Argument{
    public Boolean isRequired;

    public NamedArgument(String type, String id, Boolean isRequired){
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
