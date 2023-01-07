package flutter;
import nodes.DartInteger;
public class TextSize extends TextAtt{
   public DartInteger number ;
    public TextSize(DartInteger number){
        this.number=number;
    }

    @Override
    public String toString() {
    return "textSize:" + number.toString();
    }
}

//    : SIZE':'INT_NUM COMMA?
