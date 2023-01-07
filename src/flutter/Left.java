package flutter;

import nodes.DartInteger;

public class Left extends CostumeValues{


    public DartInteger number;
    public Left(DartInteger number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "left:"+number.toString();
    }
}
//    : LEFT':'INT_NUM COMMA?
