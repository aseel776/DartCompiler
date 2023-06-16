package flutter;

import nodes.DartInteger;

public class SizedBoxHeight extends SizedBoxAtt {
    public DartInteger number;

    public SizedBoxHeight(DartInteger number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "sizedBoxHeight:" + number.toString();
    }

    @Override
    public StringBuilder astImp() {
        StringBuilder str = new StringBuilder("sizedBox height");
        str.append("\n\t\t").append(this);
        return str;
    }

    // TODO
    // may remove css style and do another thing
    @Override
    public String codeGenerationImp() {
        String top = Utils.setCommentWidgetName("SizedBoxHeight", this.hashCode());

        top.concat("<script>");
        Utils.printLine(top);
        top.concat("var parentDiv = document.currentScript.parentNode;");
        Utils.printLine(top);
        top.concat("  parentDiv.style.height  = '" + number + "px';");
        Utils.printLine(top);
        top.concat("</script>");
        return top;
    }
}