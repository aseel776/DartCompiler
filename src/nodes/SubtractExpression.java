package nodes;

public class SubtractExpression extends Expression{

    public Expression left;
    public Expression right;

    public SubtractExpression( Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return left.toString() + '-' + right.toString();
    }

    @Override
    public StringBuilder astImp() {
        StringBuilder str = new StringBuilder("subtract");
        str.append("\n\t\t").append(left.astImp());
        str.append("\n\t\t-");
        str.append("\n\t\t").append(right.astImp());
        return str;
    }
}
