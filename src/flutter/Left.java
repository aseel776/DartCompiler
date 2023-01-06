package flutter;

import nodes.PositiveInteger;

public class Left extends CostumeValues{


    public PositiveInteger number;
    public Left(PositiveInteger number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "left:"+number.toString();
    }
}
//    : LEFT':'INT_NUM COMMA?
