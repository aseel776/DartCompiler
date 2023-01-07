package flutter;

public class TextStyle extends TextAtt{
   public String style;
    public TextStyle(String style){
        this.style= style;
    }

    @Override
    public String toString() {
        return "textStyle: " + style;
    }
}
//    : STYLE':'STYLES COMMA?
