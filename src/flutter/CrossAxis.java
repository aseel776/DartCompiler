package flutter;

import enums.Alignment;

public class CrossAxis extends Column_rowAtts{
    public Alignment al ;
    public CrossAxis(Alignment  al){
        this.al=al;
    }

    @Override
    public String toString() {
        return "crossAxisAlignment:" + al.toString();
    }
}
