package nodes;

import enums.VarOrType;

public class Argument extends Node{
    public VarOrType type;
    public String id;

    public Argument(VarOrType type, String id){
        this.type =type;
        this.id = id;
    }

    @Override
    public String toString() {
        return type.toString() + " " + id;
    }
}
