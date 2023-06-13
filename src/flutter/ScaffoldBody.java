package flutter;

import nodes.DartObject;

public class ScaffoldBody extends ScaffoldAtt {

    public DartObject object;

    public ScaffoldBody(DartObject object) {
        super();
        this.object = object;
    }

    @Override
    public String toString() {
        return "body:" + object.toString();
    }

    @Override
    public StringBuilder astImp() {
        StringBuilder str = new StringBuilder("scaffold body");
        str.append("\n\t\t").append(object.astImp());
        return str;
    }

    @Override
    public String codeGenerationImp() {

        String top = "<div " + Utils.setWidgetName("ScaffoldBody", this.hashCode())+" >" ;
        Utils.printLine(top);
        top.concat(object.codeGenerationImp());
        Utils.printLine(top);
        top.concat("</div>");

        return top;
    }
}
