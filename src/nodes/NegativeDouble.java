package nodes;

public class NegativeDouble extends NegativeNumber{
    public double num;

    public NegativeDouble(double num){
        this.num = Math.min(num, 0);
    }

    @Override
    public String toString() {
        return String.valueOf(num);
    }
}
