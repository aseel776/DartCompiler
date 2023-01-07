package nodes;

public class Signature extends Node{
    public String returnType;
    public String id;
    public Arguments arguments;

    public Signature(String returnType, String id, Arguments arguments){
        if(returnType != null){
            this.returnType = returnType;
        }
        this.id = id;
        this.arguments = arguments;
    }

    @Override
    public String toString() {
        if(returnType != null){
            return returnType.toString() + " " + id + " " + arguments.toString();
        }else {
            return id + " " + arguments.toString();
        }
    }
}
