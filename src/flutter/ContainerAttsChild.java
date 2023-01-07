package flutter;

import nodes.DartObject;

public class ContainerAttsChild extends ContainerAtt{


    public DartObject object;
    public ContainerAttsChild(DartObject object) {
        this.object = object;
    }
    @Override
    public String toString() {
        return  "containerChild: " + object.toString();

    }
}
//    : CHILD':'object COMMA?
