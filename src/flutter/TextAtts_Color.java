package flutter;

public class TextAtts_Color extends TextAtt{
    public String color ;
    public TextAtts_Color(String color){
        this.color=color;

    }

    @Override
    public String toString() {
        return "textColor: " + color;
    }
}
//    : COLOR':'COLORS COMMA?
