package flutter;

public class Scaffold extends Component{
    public ScaffoldAtts scaffoldAtts ;

    public Scaffold(ScaffoldAtts atts){
        super("Scaffold", atts);
    }

    @Override
    public String toString() {
        return "new Scaffold (\n" + scaffoldAtts.toString() + "\n)";
    }
}

