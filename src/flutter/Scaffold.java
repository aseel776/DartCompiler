package flutter;

import nodes.ZeroParameters;

public class Scaffold extends Component{
    public ScaffoldAtts scaffoldAtts ;

    public Scaffold(ScaffoldAtts atts){
        super("Scaffold", atts);
    }

    public Scaffold(){
        super("Scaffold", new ZeroParameters());
    }

    @Override
    public String toString() {
        if(scaffoldAtts != null){
            return "new Scaffold (\n" + scaffoldAtts.toString() + "\n)";
        }else{
            return "new Scaffold()";
        }
    }
}

