package flutter;

public class ScaffoldBackground extends ScaffoldAtt{

    public String color;

    public ScaffoldBackground(String color){
        super();
        this.color= color;
    }
    @Override
    public String toString() {

        return "backgroundColor:"+color.toString();
    }

    @Override
    public StringBuilder astImp() {
        StringBuilder str = new StringBuilder("scaffold background color");
        str.append("\n\t\t").append(this);
        return str;
    }

    @Override
    public String codeGenerationImp() {
        String classes[] = { "bg-" + color + "')", "w-100", "h-100" };

        String top = Utils.setCommentWidgetName("ScaffoldBackground", this.hashCode());
        top = Utils.addClassesToParentElementByScript(top, classes);

        return top;
    }
}
