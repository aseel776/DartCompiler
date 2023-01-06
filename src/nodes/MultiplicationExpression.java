package nodes;

public class MultiplicationExpression extends Expression{
    public Expression left;
    public Expression right;

    public MultiplicationExpression(Expression left, Expression right){
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return left.toString() + '*' + right.toString();
    }
}
