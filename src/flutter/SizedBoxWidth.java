package flutter;

import nodes.PositiveInteger;

public class SizedBoxWidth extends SizedBoxAtt{
    public PositiveInteger number ;

    public SizedBoxWidth(PositiveInteger number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "width:" + number.toString();
    }
}