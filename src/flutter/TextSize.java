package flutter;
import nodes.PositiveInteger;
public class TextSize extends TextAtt{
   public PositiveInteger number ;
    public TextSize(PositiveInteger number){
        this.number=number;
    }

    @Override
    public String toString() {
    return "size:" + number.toString();
    }
}

//    : SIZE':'INT_NUM COMMA?
