package flutter;

import nodes.DartInteger;

public class Vertical extends HorizontalOrVertical{
    public DartInteger number ;
    public Vertical(DartInteger number) {
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