package flutter;

import nodes.DartInteger;

public class ContainerAttsHeight extends ContainerAtt{
    public DartInteger number ;
    public ContainerAttsHeight(DartInteger number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "containerHeight:"+number.toString();
    }
}
