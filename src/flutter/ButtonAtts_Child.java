package flutter;

public class ButtonAtts_Child extends ButtonAtts{
    String object;
    public ButtonAtts_Child(String object){
        this.object=object;
    }

    @Override
    public String toString() {
        return "child:" +object.toString();
    }
}
