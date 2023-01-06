package flutter;

public class Padding extends Component{
    public PaddingAtts paddingAtts;

    public Padding(PaddingAtts paddingAtts) {
        super("Padding", paddingAtts);
        this.paddingAtts = paddingAtts;
    }

    @Override
    public String toString() {
        return "new Padding (\n" + paddingAtts.toString() + "\n)";
    }
}
//    : NEW PADDING '(' paddingAtts* ')'
