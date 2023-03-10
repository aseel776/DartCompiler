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

    @Override
    public StringBuilder astImp() {
        StringBuilder str = new StringBuilder("text size");
        str.append("\n\t\t").append(this);
        return str;
    }
}
