package nodes;

public class ConstDeclaration extends Declaration{
    public String type;
    public String id;
    public Initialization init;

    public ConstDeclaration(String type, String id, Initialization init){
        if(type != null){
            this.type = type;
        }
        this.id = id;
        this.init = init;
    }

    @Override
    public String toString() {
        if(type != null){
            return "const " + type + " " + id + " " + init.toString();
        }else {
            return "const " + id + " " + init.toString();
        }
    }
}
