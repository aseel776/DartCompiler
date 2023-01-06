package flutter;

import nodes.PositiveInteger;

public class Up extends CostumeValues{
    public PositiveInteger number;
    public Up(PositiveInteger number) {
        this.number = number;
    }
    @Override
    public String toString() {
        return "up:"+number.toString();
    }
}
