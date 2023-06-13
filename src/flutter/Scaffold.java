package flutter;

import nodes.ZeroParameters;

public class Scaffold extends Component {
    public ScaffoldAtts scaffoldAtts;

    public Scaffold(ScaffoldAtts atts) {
        super("Scaffold", atts);
        this.scaffoldAtts = atts;
    }

    public Scaffold() {
        super("Scaffold", new ZeroParameters());
    }

    @Override
    public String toString() {
        if (scaffoldAtts != null) {
            return "new Scaffold (\n" + scaffoldAtts.toString() + "\n)";
        } else {
            return "new Scaffold()";
        }
    }

    @Override
    public StringBuilder astImp() {
        StringBuilder str = new StringBuilder("scaffold");
        if (scaffoldAtts != null) {
            str.append("\n\t\t").append(scaffoldAtts.astImp());
        }
        return str;
    }

    @Override
    public String codeGenerationImp() {
        String str = "<div " + Utils.setWidgetName("Scaffold", this.hashCode()) + " >";
        Utils.printLine(str);
        if (scaffoldAtts != null) {
            str.concat(scaffoldAtts.codeGenerationImp());
            Utils.printLine(str);
        }
        str.concat("</div>");
        return str;
    }
}
