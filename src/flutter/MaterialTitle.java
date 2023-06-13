package flutter;

public class MaterialTitle extends MaterialAppAtt {

    public String title;

    public MaterialTitle(String character) {
        super();
        this.title = character;

    }

    @Override
    public String toString() {
        return "title:" + title;
    }

    @Override
    public StringBuilder astImp() {
        StringBuilder str = new StringBuilder("material title");
        str.append("\n\t\t").append(this);
        return str;
    }

    @Override
    public String codeGenerationImp() {
        String top = "<h1"+ Utils.setWidgetName("MaterialTitle", this.hashCode())+  ">";
        top.concat(title);
        top.concat("</h1> ");
        Utils.printLine(top);
        return top;
    }
}
