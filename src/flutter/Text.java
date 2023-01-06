package flutter;

public class Text extends Component {
    public TextAtts textAtts;

    public Text(TextAtts atts) {
        super("Text", atts);
        this.textAtts = atts;
    }

    @Override
    public String toString() {
        return "new Text (\n" + textAtts.toString() + "\n);";
    }
}