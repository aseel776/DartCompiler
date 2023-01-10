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
}
