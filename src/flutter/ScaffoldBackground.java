package flutter;

import enums.Color;

public class ScaffoldBackground extends ScaffoldAtt{

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
