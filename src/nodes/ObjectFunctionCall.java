package nodes;

public class ObjectFunctionCall extends FunctionCall {

    public String objectId;

    public ObjectFunctionCall(String objectId, Boolean await, String id, Parameters parameters){
        super(await, id, parameters);
        this.objectId = objectId;
    }

    @Override
    public String toString() {
        if(await){
            return "await" + " " + objectId + "." + id + parameters.toString() + ";" ;
        }else {
            return objectId + "." + id + parameters.toString() + ";" ;
        }
    }

    @Override
    public StringBuilder astImp() {
        StringBuilder str = new StringBuilder("object function call");
        str.append("\n\t\t").append(objectId);
        str.append("\n\t\t").append(id);
        str.append("\n\t\t").append(parameters.astImp());
        return str;
    }
}
