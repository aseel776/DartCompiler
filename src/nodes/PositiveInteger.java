package nodes;

public class PositiveInteger extends PositiveNumber{
    public int num;

    public PositiveInteger(int num){
        this.num = Math.max(num, 0);
    }

    @Override
    public String toString() {
        return String.valueOf(num);
    }
}
