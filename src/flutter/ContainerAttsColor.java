package flutter;

public class ContainerAttsColor extends ContainerAtt {
    public String color;

    public ContainerAttsColor(String color) {

        this.color = color;
    }

    @Override
    public String toString() {

        return "containerColor: " + color.toString();
    }

    @Override
    public StringBuilder astImp() {
        StringBuilder str = new StringBuilder("container color");
        str.append("\n\t\t").append(this);
        return str;
    }

    @Override
    public String codeGenerationImp() {
        String top = Utils.setCommentWidgetName("ContainerAttsColor", this.hashCode());

        top.concat("<script>");
        Utils.printLine(top);
        top.concat("var parentDiv = document.currentScript.parentNode;");
        Utils.printLine(top);
        top.concat("parentDiv." + Utils.setClassNameByJs("bg-" + Utils.getBootstrapColor(color)));
        Utils.printLine(top);
        top.concat("</script>");
        return top;
    }
}
