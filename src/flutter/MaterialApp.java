package flutter;

import nodes.ZeroParameters;

public class MaterialApp extends Component{
   public MaterialAppAtts materialAppAtts ;

    public MaterialApp(MaterialAppAtts atts){
        super("MaterialApp", atts);
        this.materialAppAtts= atts;
    }

    public MaterialApp(){
        super("MaterialApp", new ZeroParameters());
    }

    @Override
    public String toString() {
       if(materialAppAtts != null){
           return "new MaterialApp (\n" + materialAppAtts.toString() + "\n)";
       }else{
           return "new MaterialApp()";
       }
    }
}