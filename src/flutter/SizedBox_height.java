package flutter;

import nodes.PositiveInteger;

public class SizedBox_height extends SizedBoxAtts{
    public PositiveInteger number ;

    public SizedBox_height( PositiveInteger number ){
        this.number=number;
    }

    @Override
    public String toString() {
        return "height:" +number.toString();
    }
}

//height
//        : HEIGHT':'INT_NUM COMMA?
//        ;