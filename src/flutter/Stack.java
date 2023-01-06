package flutter;

import java.util.ArrayList;
import java.util.List;

public class Stack extends Component{
    public List<StackAtts> stackAtts ;
    public Stack(){
        this.stackAtts= new ArrayList<>();
    }
    public Stack(List<StackAtts> listt ){
        this.stackAtts= listt;
    }
    public void addStackAtts(StackAtts cm ){
        stackAtts.add(cm);
    }
    @Override
    public String toString() {
        String top= new String( "new Stack (" )  ;
        for (int i = 0; i < stackAtts.size(); i++) {
            if (i == stackAtts.size() - 1) {
                top = top.concat(stackAtts.toString() + "\n");
            } else {
                top = top.concat(stackAtts.toString() + "," + "\n");
            }
        }
        top = top.concat(")");
        return top ;
    }
}
//    : NEW STACK '(' stackAtts* ')'

