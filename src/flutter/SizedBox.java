package flutter;

import nodes.ZeroParameters;

public class SizedBox extends Component {

    public SizedBoxAtts sizedBoxAtts;

    public SizedBox(SizedBoxAtts sizedBoxAtts) {
        super("SizedBox", sizedBoxAtts);
        this.sizedBoxAtts = sizedBoxAtts;
    }

    public SizedBox(){
        super("SizedBox", new ZeroParameters());
    }

    @Override
    public String toString() {
        if(sizedBoxAtts != null){
            return "new SizedBox (\n" + sizedBoxAtts.toString() + "\n)";
        }else{
            return "new SizedBox ()";
        }
    }

    @Override
    public StringBuilder astImp() {
        StringBuilder str = new StringBuilder("sizedBox");
        if(sizedBoxAtts != null){
            str.append("\n\t\t").append(sizedBoxAtts.astImp());
        }
        return str;
    }
}