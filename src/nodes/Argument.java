package nodes;

public class Argument extends Node{

    public String type;
    public String id;

    public Argument(String type, String id){
        if(type != null){
            this.type =type;
        }
        this.id = id;
    }

    @Override
    public String toString() {
        if(type != null){
            return type + " " + id;
        }else{
            return id;
        }
    }

    @Override
    public StringBuilder astImp() {
        return new StringBuilder("arg ").append(this);
    }
}
