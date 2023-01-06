package flutter;

public class Button extends Component{
    public ButtonAtts buttonAtts ;
    public Button(ButtonAtts buttonAtts) {
        super("Button", buttonAtts);
        this.buttonAtts = buttonAtts;
    }

    @Override
    public String toString() {
        return "new Button (\n" + buttonAtts.toString() + "\n)";
    }
}
