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

    @Override
    public StringBuilder astImp() {
        StringBuilder str = new StringBuilder("inkwell child");
        str.append("\n\t\t").append(object.astImp());
        return str;
    }
}
