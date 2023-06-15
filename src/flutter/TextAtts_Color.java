package flutter;

public class TextAtts_Color extends TextAtt {

    public String color;

    public TextAtts_Color(String color) {
        this.color = color;

    }

    @Override
    public String toString() {
        return "textColor: " + color;
    }

    @Override
    public StringBuilder astImp() {
        StringBuilder str = new StringBuilder("text color");
        str.append("\n\t\t").append(this);
        return str;
    }

    @Override
    public String codeGenerationImp() {
        String top = Utils.setCommentWidgetName("TextAtts_color", this.hashCode());
        top.concat("<script>");
        Utils.printLine(top);
        top.concat("var parentDiv = document.currentScript.parentNode;");
        Utils.printLine(top);
        top.concat("parentDiv." + Utils.setClassNameByJs("text-" + Utils.getBootstrapColor(color)));
        Utils.printLine(top);
        top.concat("</script>");
        return top;
    }
}
