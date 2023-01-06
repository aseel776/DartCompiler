package flutter;

import nodes.PositiveInteger;

public class containerAttsWidth extends ContainerAtts{
    public PositiveInteger number ;
    public containerAttsWidth(PositiveInteger number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "width:"+number.toString();
    }
}
//    : WIDTH':'INT_NUM COMMA?
