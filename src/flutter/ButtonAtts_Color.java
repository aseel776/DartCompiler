package flutter;

import enums.Color;

public class ButtonAtts_Color extends ButtonAtts{
    public Color color;

    public ButtonAtts_Color(Color color){

        this.color= color;
    }
    @Override
    public String toString() {

        return "color:"+color.toString();
    }
}
