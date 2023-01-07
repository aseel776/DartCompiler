package flutter;

import nodes.DartInteger;

public class SizedBoxWidth extends SizedBoxAtt{
    public DartInteger number ;

    public SizedBoxWidth(DartInteger number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "sizedBoxWidth:" + number.toString();
    }
}