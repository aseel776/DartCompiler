package flutter;
import nodes.PositiveInteger;
public class All extends PaddingValues {
     public PositiveInteger number;
    public All(PositiveInteger number) {
        this.number = number;
    }
    @Override
    public String toString() {
        return "values: PaddingValues.all("+number.toString() +")";
    }
}



