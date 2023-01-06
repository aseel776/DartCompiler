package flutter;

import enums.Color;

public class ContainerAttsColor extends ContainerAtts {
    public Color color;

    public ContainerAttsColor(Color color){

        this.color= color;
    }
    @Override
    public String toString() {

        return "color:"+color.toString();
    }
}
//    : COLOR':'COLORS COMMA?
