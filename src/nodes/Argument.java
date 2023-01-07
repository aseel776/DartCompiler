package nodes;

public class Argument extends Node{
    public String type;
    public String id;

    public Argument(String type, String id){
        this.type =type;
        this.id = id;
    }

    @Override
    public String toString() {
        return type.toString() + " " + id;
    }
}
