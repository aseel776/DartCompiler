package flutter;

import nodes.ZeroParameters;

public class Container extends Component{
   ContainerAtts containerAtts;

   public Container(ContainerAtts containerAtts){
       super("Container",containerAtts);
       this.containerAtts=containerAtts;
   }

   public Container(){
       super("Container", new ZeroParameters());
   }

    @Override
    public String toString() {
        if(containerAtts != null){
            return "new Container (\n" + containerAtts.toString()+"\n);";
        }else {
            return "new Container ()";
        }
    }
}
