package nodes;

public class Parameter extends Node{
    public Node value;

    public Parameter(Node value){
        this.value = value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
