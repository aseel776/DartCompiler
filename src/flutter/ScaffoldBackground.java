package flutter;

public class ScaffoldBackground extends ScaffoldAtt{

    public String color;

    public ScaffoldBackground(String color){
        super();
        this.color= color;
    }
    @Override
    public String toString() {

        return "backgroundColor:"+color.toString();
    }

    @Override
    public StringBuilder astImp() {
        StringBuilder str = new StringBuilder("scaffold background color");
        str.append("\n\t\t").append(this);
        return str;
    }
}
