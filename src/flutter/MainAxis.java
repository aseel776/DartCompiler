package flutter;

import enums.Alignment;

public class MainAxis extends Column_rowAtts{
    public Alignment  al ;
    public MainAxis(Alignment  al){
        this.al=al;
    }

    @Override
    public String toString() {
        return "mainAxisAlignment:" + al.toString();
    }
}
//    : CROSS_AXIS_ALIGNMENT':'ALIGNMENT COMMA?
