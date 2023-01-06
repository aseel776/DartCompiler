package nodes;

public class Increment extends Node{
    public String id;
    public String symbol;
    public Expression expression;

    public Increment(String id, String symbol, Expression expression){
        this.id = id;
        this.symbol = symbol;
        this.expression = expression;
    }

    @Override
    public String toString() {
        return id + symbol + expression.toString();
    }
}
