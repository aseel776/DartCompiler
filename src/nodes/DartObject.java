package nodes;

public class DartObject extends Statement {

    public String id;
    public Parameters parameters;

    public DartObject(String id, Parameters parameters){
        this.id = id;
        this.parameters = parameters;
    }

    @Override
    public String toString() {
        return "new" + " " + id + parameters.toString();
    }

    @Override
    public StringBuilder astImp() {
        StringBuilder str = new StringBuilder("object");
        str.append("\n\t\t").append(id);
        str.append("\n\t\t").append(parameters.astImp());
        return str;
    }
}