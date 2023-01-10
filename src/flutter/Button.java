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
            return "new Button (\n" + buttonAtts.toString() + ")";
        }else{
            return "new Button ()";
        }
    }

    @Override
    public StringBuilder astImp() {
        StringBuilder str = new StringBuilder("button");
        if(buttonAtts != null){
            str.append("\n\t\t").append(buttonAtts.astImp());
        }
        return str;
    }
}
