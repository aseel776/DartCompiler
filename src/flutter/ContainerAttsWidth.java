package flutter;

import nodes.PositiveInteger;

public class ContainerAttsWidth extends ContainerAtt{
    public PositiveInteger number ;
    public ContainerAttsWidth(PositiveInteger number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "width:"+number.toString();
    }
}
//    : WIDTH':'INT_NUM COMMA?
