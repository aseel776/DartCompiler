package flutter;

public class ButtonColor extends ButtonAtt{
    public String color;

    public ButtonColor(String color){

        this.color= color;
    }
    @Override
    public String toString() {

        return "buttonColor: " + color;
    }
}
