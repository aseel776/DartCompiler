package flutter;

import nodes.ZeroParameters;

public class Padding extends Component{
    public PaddingAtts paddingAtts;

    public Padding(PaddingAtts paddingAtts) {
        super("Padding", paddingAtts);
        this.paddingAtts = paddingAtts;
    }

    public Padding(){
        super("Padding", new ZeroParameters());
    }

    @Override
    public String toString() {
        if(paddingAtts != null){
            return "new Padding (\n" + paddingAtts.toString() + "\n)";
        }else{
            return "new Padding ()";
        }
    }
}
