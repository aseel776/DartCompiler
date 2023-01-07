package nodes;

public class DartDouble extends Number {
    public double num;

    public DartDouble(double num){
        this.num = num;
    }

    @Override
    public String toString() {
        return String.valueOf(num);
    }
}
