package nodes;

public class Comparison extends Node{
    public Variable left;
    public Expression right;
    public String symbol;

    public Comparison(Variable left, Expression right, String symbol){
        this.left = left;
        this.right = right;
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return left.toString() + symbol + right.toString();
    }
}
