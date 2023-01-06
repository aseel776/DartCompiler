package flutter;

import java.util.ArrayList;
import java.util.List;

public class Container extends Component{
    public List<ContainerAtts> containerAtts;
    public Container(List<ContainerAtts> containerAtts) {
        this.containerAtts = containerAtts;
    }
    public Container(){
        this.containerAtts= new ArrayList<>();
    }
    public void addContainerAttr(ContainerAtts a){
        this.containerAtts.add(a);
    }
    @Override
    public String toString() {
        String string=  new String("new Container(") ;
        for (int i = 0; i < containerAtts.size(); i++) {
            if (i == containerAtts.size() - 1) {
                string = string.concat(containerAtts.get(i).toString() + "\n");
            } else {
                string = string.concat(containerAtts.get(i).toString() + "," + "\n");
            }
        }
        string =string.concat(")");
        return string;
    }
}
//    : NEW CONTAINER '(' containerAtts* ')'
