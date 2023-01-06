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
}
