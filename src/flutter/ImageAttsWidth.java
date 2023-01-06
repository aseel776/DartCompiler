package flutter;

import nodes.PositiveInteger;

public class ImageAttsWidth extends ImageAtts{
    PositiveInteger number ;
    public ImageAttsWidth(PositiveInteger number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "width:"+number.toString();
    }
}
//    : WIDTH':'INT_NUM COMMA?
