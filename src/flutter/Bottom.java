package flutter;

import nodes.DartInteger;

public class Bottom extends CostumeValues{
    public DartInteger number;
    public Bottom(DartInteger number) {
        this.number = number;
    }
    @Override
    public String toString() {
        return "bottom:"+number.toString();
    }
}
