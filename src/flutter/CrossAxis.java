package flutter;

public class CrossAxis extends Column_rowAtt{

    public String al ;

    public CrossAxis(String  al){
        this.al=al;
    }

    @Override
    public String toString() {
        return "crossAxisAlignment:" + al;
    }

    @Override
    public StringBuilder astImp() {
        StringBuilder str = new StringBuilder("cross axis alignment");
        str.append("\n\t\t").append(this);
        return str;
    }
    @Override
    public String codeGenerationImp() {
        String top= Utils.setCommentWidgetName("CrossAxis", this.hashCode());

        top.concat("<script>");
        Utils.printLine(top);
        top.concat("var parentDiv = document.currentScript.parentNode;" );
        Utils.printLine(top);
        // Add a class to the parent element <div class="d-flex flex-column|row + ></div>"
        top.concat("parentDiv."+Utils.setClassNameByJs("align-items-"+al) );
        Utils.printLine(top);
        top.concat("</script>");

        return top;
    }
}
