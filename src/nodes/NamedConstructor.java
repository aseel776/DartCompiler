package nodes;

public class NamedConstructor extends ClassMethod{
    public String classId;
    public String id;
    public ConsArgs args;
    private final Boolean hasBody;
    public FunctionBody consBody;

    public NamedConstructor(String classId, String id, ConsArgs args, FunctionBody consBody){
        this.classId = classId;
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
        String cons = classId + '.' + id + args.toString();
        if(hasBody){
            cons = cons.concat(consBody.toString());
        }else {
            cons = cons.concat(";");
        }
        return cons;
    }
}
