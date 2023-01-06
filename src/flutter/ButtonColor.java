package flutter;

import enums.Color;

public class ButtonColor extends ButtonAtt{
    public Color color;

    public ButtonColor(Color color){

        this.color= color;
    }
    @Override
    public String toString() {

        return "color:"+color.toString();
    }
}
