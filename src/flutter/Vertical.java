package flutter;

import nodes.PositiveInteger;

public class Vertical extends HorizontalOrVertical{
    public PositiveInteger number ;
    public Vertical(PositiveInteger number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return  "vertical:"+number.toString();
    }
}
//horizontalOrVertical
//        : HORIZONTAL':'INT_NUM COMMA?
//        | VERTICAL':' INT_NUM COMMA?
//        ;