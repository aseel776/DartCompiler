package nodes;

import enums.VoidOrType;

public class Signature extends Node{
    public VoidOrType returnType;
    public String id;
    public Arguments arguments;

    public Signature(VoidOrType returnType, String id, Arguments arguments){
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
