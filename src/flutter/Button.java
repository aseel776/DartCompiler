package flutter;

import nodes.ZeroParameters;

public class Button extends Component{
    public ButtonAtts buttonAtts ;
    public Button(ButtonAtts buttonAtts) {
        super("Button", buttonAtts);
        this.buttonAtts = buttonAtts;
    }

    public Button(){
        super("Button", new ZeroParameters());
    }

    @Override
    public String toString() {
        if(buttonAtts != null){
            return "new Button (\n" + buttonAtts.toString() + "\n)";
        }else{
            return "new Button ()";
        }
    }
}
