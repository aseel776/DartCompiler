package nodes;

public class Initialization extends Node{
    public Node value;

    public Initialization(Node value){
        this.value = value;
    }

    @Override
    public String toString() {
        return "= " + value.toString();
    }
}
