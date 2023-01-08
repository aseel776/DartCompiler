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
}