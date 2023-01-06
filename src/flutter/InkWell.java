package flutter;

import java.util.ArrayList;
import java.util.List;

public class InkWell extends Component{
    public InkwellAtts inkwellAtts ;
    public InkWell(InkwellAtts inkwellAtts){
        super("InkWell", inkwellAtts);
        this.inkwellAtts= inkwellAtts;
    }
    @Override
    public String toString() {
        return "new InkWell (\n" + inkwellAtts.toString() + "\n)";
    }
}
