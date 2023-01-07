package flutter;

public class MainAxis extends Column_rowAtt{
    public String  al ;
    public MainAxis(String  al){
        this.al=al;
    }
    @Override
    public String toString() {
        return "mainAxisAlignment:" + al;
    }
}
//    : CROSS_AXIS_ALIGNMENT':'ALIGNMENT COMMA?
