package nodes;

public class ConstDeclaration extends Declaration{

    public String type;
    public Initialization init;

    public ConstDeclaration(String type, String id, Initialization init){
        super(id);
        if(type != null){
            this.type = type;
        }
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

    @Override
    public StringBuilder astImp() {
        StringBuilder str = new StringBuilder("declaration");
        str.append("\n\t\t").append(this);
        return str;
    }
    @Override
    public String codeGenerationImp() {
        String str = "$" + id;
        if (init != null) {
            str = str.concat(' ' + init.codeGenerationImp());
        }
        return str;
    }
}
