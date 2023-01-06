package nodes;

public class NegativeInteger extends NegativeNumber {
    public int num;

    public NegativeInteger(int num){
        this.num = Math.min(num, 0);
    }

    @Override
    public String toString() {
        return String.valueOf(num);
    }
}
