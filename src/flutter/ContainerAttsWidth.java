package flutter;

import nodes.DartInteger;

public class ContainerAttsWidth extends ContainerAtt{
    public DartInteger number ;
    public ContainerAttsWidth(DartInteger number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "containerWidth:"+number.toString();
    }
}
//    : WIDTH':'INT_NUM COMMA?
