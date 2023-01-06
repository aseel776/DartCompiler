package flutter;

import java.util.ArrayList;
import java.util.List;

public class Container extends Component{
   ContainerAtts containerAtts;
   public Container(ContainerAtts containerAtts){
       super("Container",containerAtts);
       this.containerAtts=containerAtts;

   }
    @Override
    public String toString() {
        return "new Container (\n" + containerAtts.toString()+"\n);";
    }

}
//    : NEW CONTAINER '(' containerAtts* ')'
