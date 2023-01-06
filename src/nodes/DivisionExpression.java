package nodes;

public class DivisionExpression extends Expression{
    public Expression left;
    public Expression right;

    public DivisionExpression(Expression left, Expression right){
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return left.toString() + '/' + right.toString();
    }
}
