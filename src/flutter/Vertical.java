package flutter;

import nodes.DartInteger;

public class Vertical extends HorizontalOrVertical{

    public DartInteger number ;

    public Vertical(DartInteger number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return  "vertical:"+number.toString();
    }

    @Override
    public StringBuilder astImp() {
        StringBuilder str = new StringBuilder("vertical");
        str.append("\n\t\t").append(this);
        return str;
    }
}