package nodes;

public class Comparison extends Node{
    public Node left;
    public Node right;
    public String symbol;

    public Comparison(Node left, Node right, String symbol){
        this.left = left;
        this.right = right;
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return left.toString() + symbol + right.toString();
    }
}
