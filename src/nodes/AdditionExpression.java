package nodes;

public class AdditionExpression extends Expression{
    public Expression left;
    public Expression right;

    public AdditionExpression( Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return left.toString() + '+' + right.toString();
    }

}
