package flutter;

import nodes.DartInteger;

public class SizedBoxHeight extends SizedBoxAtt{
    public DartInteger number ;

    public SizedBoxHeight(DartInteger number ){
        this.number=number;
    }

    @Override
    public String toString() {
        return "sizedBoxHeight:" +number.toString();
    }

    @Override
    public StringBuilder astImp() {
        StringBuilder str = new StringBuilder("sizedBox height");
        str.append("\n\t\t").append(this);
        return str;
    }
}