package flutter;

public class TextStyle extends TextAtt {
    public String style;

    public TextStyle(String style) {
        this.style = style;
    }

    @Override
    public String toString() {
        return "textStyle: " + style;
    }

    @Override
    public StringBuilder astImp() {
        StringBuilder str = new StringBuilder("text style");
        str.append("\n\t\t").append(this);
        return str;
    }

    @Override
    public String codeGenerationImp() {
        String top = Utils.setCommentWidgetName("TextStyle", this.hashCode());
        // TODO
        // add class name in conditions 
        String className;
        if (style == "Italic")
            className = "";
        else if (style == "Bold")
            className = "";
        else
            className = "";

        top.concat("<script>");
        Utils.printLine(top);
        top.concat("var parentDiv = document.currentScript.parentNode;");
        Utils.printLine(top);
        top.concat("parentDiv." + Utils.setClassNameByJs(className));
        Utils.printLine(top);
        top.concat("</script>");
        return top;

    }
}
