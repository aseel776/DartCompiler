package nodes;

public class Condition extends Node{

    public Comparison comparison;
    public Boolean value;

    public Condition(Comparison comp){
        this.comparison = comp;
    }

    @Override
    public String toString() {
        return comparison.toString();
    }
}
