package flutter;
import nodes.PositiveInteger;
public class All extends Values{
     public PositiveInteger number;
    public All(PositiveInteger number) {
        this.number = number;
    }
    @Override
    public String toString() {
        return "Values.all("+number.toString() +")";
    }
}



