package flutter;

import enums.Color;

public class ScaffoldBackground extends ScaffoldAtts{

    public Color color;

    public ScaffoldBackground(Color color){
        super();
        this.color= color;
    }
    @Override
    public String toString() {

        return "backgroundColor:"+color.toString();
    }

}
//    : COLOR':'COLORS COMMA?
