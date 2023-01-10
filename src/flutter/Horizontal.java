package flutter;

import nodes.DartInteger;

public class Horizontal extends HorizontalOrVertical{

    public DartInteger number ;
    public Horizontal(DartInteger number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return  "horizontal:"+number.toString();
    }

    @Override
    public StringBuilder astImp() {
        StringBuilder str = new StringBuilder("horizontal");
        str.append("\n\t\t").append(this);
        return str;
    }

}
