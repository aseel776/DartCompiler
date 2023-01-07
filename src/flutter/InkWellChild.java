package flutter;

import nodes.DartObject;

public class InkWellChild extends InkWellAtt{

    public DartObject object;

    public InkWellChild(DartObject object){
        this.object = object;
    }

    @Override
    public String toString() {
        return "inkWellChild: " + object.toString();
    }
}
