package flutter;

public class MainAxis extends Column_rowAtt{

    public String  al ;

    public MainAxis(String  al){
        this.al=al;
    }

    @Override
    public String toString() {
        return "mainAxisAlignment:" + al;
    }

    @Override
    public StringBuilder astImp() {
        StringBuilder str = new StringBuilder("main axis alignment");
        str.append("\n\t\t").append(this);
        return str;
    }
    @Override
    public String codeGenerationImp() {

        String top= Utils.setCommentWidgetName("MainAxis", this.hashCode());

        top.concat("<script>");
        Utils.printLine(top);
        top.concat("var parentDiv = document.currentScript.parentNode;" );
        Utils.printLine(top);
        // Add a class to the parent element <div class="d-flex flex-column|row + ></div>"
        top.concat("parentDiv."+Utils.setClassNameByJs("justify-content-"+al) );
        Utils.printLine(top);
        top.concat("</script>");

        return top;
    }
}
