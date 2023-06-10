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

    @Override
    public StringBuilder astImp() {
        StringBuilder str = new StringBuilder("container height");
        str.append("\n\t\t").append(this);
        return str;
    }
}
