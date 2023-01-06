package flutter;

import java.util.ArrayList;
import java.util.List;

public class Padding extends Component{
    public List<PaddingAtts> paddingAtts;

    public Padding(List<PaddingAtts> paddingAtts) {
        this.paddingAtts = paddingAtts;
    }

    public Padding(){
        this.paddingAtts= new ArrayList<>();
    }
    public void addPaddingAtts(PaddingAtts paddingAttss){
        this.paddingAtts.add(paddingAttss);
    }

    @Override
    public String toString() {
        String string=  new String("new Padding(") ;
        for (int i = 0; i < paddingAtts.size(); i++) {
            if (i == paddingAtts.size() - 1) {
                string = string.concat(paddingAtts.toString() + "\n");
            } else {
                string = string.concat(paddingAtts.toString() + "," + "\n");
            }
        }
        string =string.concat(")");
        return string;

    }
}
//    : NEW PADDING '(' paddingAtts* ')'
