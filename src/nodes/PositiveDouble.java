package nodes;

public class PositiveDouble extends PositiveNumber{
    public double num;

    public PositiveDouble(double num){
        this.num = Math.max(num, 0);
    }

    @Override
    public String toString() {
        return String.valueOf(num);
    }
}
