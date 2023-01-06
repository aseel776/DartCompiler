package flutter;

import nodes.PositiveInteger;

public class SizedBoxHeight extends SizedBoxAtt{
    public PositiveInteger number ;

    public SizedBoxHeight(PositiveInteger number ){
        this.number=number;
    }

    @Override
    public String toString() {
        return "height:" +number.toString();
    }
}