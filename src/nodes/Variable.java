package nodes;

public class Variable extends Node{
    public String id;

    public Variable(String id){
        this.id = id;
    }

    @Override
    public String toString() {
        return id;
    }
}
