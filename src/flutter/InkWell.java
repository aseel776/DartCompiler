package flutter;

import java.util.ArrayList;
import java.util.List;

public class InkWell extends Component{
    public List<InkwellAtts> InkwellAtts ;
    public InkWell(){
        this.InkwellAtts= new ArrayList<>();
    }
    public InkWell(List<InkwellAtts> listt){
        this.InkwellAtts= listt;
    }
    @Override
    public String toString() {
        String top= new String( "new InkWell (" )  ;
        for (int i = 0; i < InkwellAtts.size(); i++) {
            if (i == InkwellAtts.size() - 1) {
                top = top.concat(InkwellAtts.toString() + "\n");
            } else {
                top = top.concat(InkwellAtts.toString() + "," + "\n");
            }
        }
        top = top.concat(")");
        return top ;
    }
}
