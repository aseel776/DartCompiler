package flutter;
import java.util.ArrayList;
import java.util.List;
public class MaterialApp extends Component{
   public List<MaterialAppAtts> materialAppAtts ;
   public MaterialApp(){
       this.materialAppAtts= new ArrayList<>();
   }
    public MaterialApp(List<MaterialAppAtts> listt ){
        this.materialAppAtts= listt;
    }
   public void addMaterialAppAtts(MaterialAppAtts cm ){
       materialAppAtts.add(cm);
   }
    @Override
    public String toString() {
       String top= new String( "new MaterialApp (" )  ;
        for (int i = 0; i < materialAppAtts.size(); i++) {
            if (i == materialAppAtts.size() - 1) {
                top = top.concat(materialAppAtts.toString() + "\n");
            } else {
                top = top.concat(materialAppAtts.toString() + "," + "\n");
            }
        }
        top = top.concat(")");
        return top ;
    }
}
//    : NEW MATERIAL_APP '(' materialAppAtts* ')')