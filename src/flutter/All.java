package flutter;
import nodes.DartInteger;
public class All extends PaddingValues {
     public DartInteger number;
    public All(DartInteger number) {
        this.number = number;
    }
    @Override
    public String toString() {
        return "values: PaddingValues.all("+number.toString() +")";
    }
}



