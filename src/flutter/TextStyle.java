package flutter;

import enums.Style;

public class TextStyle extends TextAtt{
   public Style style;
    public TextStyle(  Style style){
        this.style= style;
    }

    @Override
    public String toString() {
        return "style:" + style.toString();
    }
}
//    : STYLE':'STYLES COMMA?
