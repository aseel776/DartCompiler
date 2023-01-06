package flutter;

public class MaterialApp extends Component{
   public MaterialAppAtts materialAppAtts ;

    public MaterialApp(MaterialAppAtts atts){
        super("MaterialApp", atts);
        this.materialAppAtts= atts;
    }
    @Override
    public String toString() {
       return "new MaterialApp (\n" + materialAppAtts.toString() + "\n)";
    }
}