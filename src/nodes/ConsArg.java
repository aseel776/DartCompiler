package nodes;

import enums.TypeOrThis;

public class ConsArg extends Node {
    public TypeOrThis type;
    public String id;

    public ConsArg(TypeOrThis type, String id){
        if(type != null) {
            this.type = type;
        }
        this.id = id;
    }

    @Override
    public String toString() {
        if(type != null){
            if(type == TypeOrThis.THIS){
                return "this." + id;
            }else{
                return type.toString() + " " + id;
            }
        }else{
            return id;
        }
    }
}
