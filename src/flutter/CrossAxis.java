package flutter;

public class CrossAxis extends Column_rowAtt{

    public String al ;

    public CrossAxis(String  al){
        this.al=al;
    }

    @Override
    public String toString() {
        return "crossAxisAlignment:" + al;
    }

    @Override
    public StringBuilder astImp() {
        StringBuilder str = new StringBuilder("cross axis alignment");
        str.append("\n\t\t").append(this);
        return str;
    }
}
