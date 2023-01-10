package flutter;

import nodes.ZeroParameters;

import java.util.ArrayList;
import java.util.List;

public class InkWell extends Component{

    public InkwellAtts inkwellAtts ;

    public InkWell(InkwellAtts inkwellAtts){
        super("InkWell", inkwellAtts);
        this.inkwellAtts= inkwellAtts;
    }

    public InkWell(){
        super("InkWell", new ZeroParameters());
    }

    @Override
    public String toString() {
        if(inkwellAtts != null){
            return "new InkWell (\n" + inkwellAtts.toString() + ")";
        }else {
            return "new InkWell ()";
        }
    }

    @Override
    public StringBuilder astImp() {
        StringBuilder str = new StringBuilder("inkwell");
        if(inkwellAtts != null){
            str.append("\n\t\t").append(inkwellAtts.astImp());
        }
        return str;
    }
}
