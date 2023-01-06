package flutter;

import nodes.PositiveInteger;

public class Bottom extends CostumeValues{
    public PositiveInteger number;
    public Bottom(PositiveInteger number) {
        this.number = number;
    }
    @Override
    public String toString() {
        return "bottom:"+number.toString();
    }
}
