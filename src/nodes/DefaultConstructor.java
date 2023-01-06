package nodes;

public class DefaultConstructor extends Node {
    public String id;
    public ConsArgs args;
    private final Boolean hasBody;
    public FunctionBody consBody;

    public DefaultConstructor(String id, ConsArgs args, FunctionBody consBody){
        this.id = id;
        this.args = args;
        if(consBody != null){
            this.consBody = consBody;
            hasBody = true;
        }else {
            hasBody = false;
        }
    }

    @Override
    public String toString() {
        String cons = id + " " + args.toString();
        if(hasBody){
            cons = cons.concat(consBody.toString());
        }else {
            cons = cons.concat(";");
        }
        return cons;
    }
}
