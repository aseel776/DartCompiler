package flutter;

import nodes.DartObject;

public class ScrollViewChild extends ScrollViewAtt{
    public DartObject object;
    public ScrollViewChild(DartObject object) {
        this.object = object;
    }
    @Override
    public String toString() {
        return  "scrollChild: "+ object.toString();
    }
}

