package nodes;

import enums.Type;

public class ConstDeclaration extends Declaration{
    public Type type;
    public String id;
    public Initialization init;

    public ConstDeclaration(Type type, String id, Initialization init){
        if(type != null){
            this.type = type;
        }
        this.id = id;
        this.init = init;
    }

    @Override
    public String toString() {
        if(type != null){
            return "const " + type.toString() + " " + id + " " + init.toString() + ";";
        }else {
            return "const " + id + " " + init.toString() + ";";
        }
    }
}
