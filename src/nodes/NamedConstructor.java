package nodes;

public class NamedConstructor extends ClassMethod{

    public String classId;
    public String id;
    public ConsArgs args;
    public FunctionBody consBody;

    public NamedConstructor(String classId, String id, ConsArgs args, FunctionBody consBody){
        this.classId = classId;
        this.id = id;
        this.args = args;
        if(consBody != null) {
            this.consBody = consBody;
        }
    }

    @Override
    public String toString() {
        String cons = classId + '.' + id + args.toString();
        if(consBody != null){
            cons = cons.concat(consBody.toString());
        }else {
            cons = cons.concat(";");
        }
        return cons;
    }

    @Override
    public StringBuilder astImp() {
        StringBuilder str = new StringBuilder("class method");
        str.append("\n\t\tnamed constructor");
        str.append("\n\t\t").append(classId);
        str.append("\n\t\t").append(id);
        str.append("\n\t\t").append(args.astImp());
        if(consBody != null){
            str.append("\n\t\t").append(consBody.astImp());
        }
        return str;
    }
}
