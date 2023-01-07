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

}
