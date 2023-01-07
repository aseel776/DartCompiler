package flutter;

import nodes.DartInteger;

public class Right  extends CostumeValues {
    public DartInteger number;
    public Right(DartInteger number) {
        this.number = number;
    }
    @Override
    public String toString() {
        return "right:"+number.toString();
    }
}