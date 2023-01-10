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

    @Override
    public StringBuilder astImp() {
        StringBuilder str = new StringBuilder("container width");
        str.append("\n\t\t").append(this);
        return str;
    }
}
