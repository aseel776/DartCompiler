package flutter;

import nodes.PositiveInteger;

public class SizedBox_width extends SizedBoxAtts{
    public PositiveInteger number ;

    public SizedBox_width(PositiveInteger number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "width:" + number.toString();
    }
}
;
//width
//        : WIDTH':'INT_NUM COMMA?
//        ;