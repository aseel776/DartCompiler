package flutter;

import nodes.DartObject;

public class PaddingChild extends PaddingAtt{

    public DartObject object ;

    public PaddingChild(DartObject object) {
        this.object = object;
    }
    @Override
    public String toString() {
        return "paddingChild: " +object.toString() ;

    }

}
