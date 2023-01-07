package flutter;

import nodes.ZeroParameters;

public class Text extends Component {
    public String text;
    public TextAtts textAtts;

    public Text(String text, TextAtts atts) {
        super("Text", atts);
        this.text =text;
        this.textAtts = atts;
    }

    public Text(String text){
        super("Text", new ZeroParameters());
    }

    @Override
    public String toString() {
        if(textAtts != null){
            return "new Text (\n" + text + '\n' + textAtts.toString() + "\n);";
        }else{
            return "new Text (\n" + text + "\n)";
        }
    }
}