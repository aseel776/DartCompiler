package flutter;

public class TextAtts_Color extends TextAtt{
    public enums.Color color ;
    public TextAtts_Color(enums.Color color){
        this.color=color;

    }

    @Override
    public String toString() {
        return "color:"+color.toString();
    }
}
//    : COLOR':'COLORS COMMA?
