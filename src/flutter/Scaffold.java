package flutter;

import java.util.ArrayList;
import java.util.List;

public class Scaffold extends Component{

    public List<ScaffoldAtts> scaffoldAtts ;
    public Scaffold(){
        this.scaffoldAtts= new ArrayList<>();
    }
    public Scaffold(List<ScaffoldAtts> listt ){
        this.scaffoldAtts= listt;
    }
    public void addScaffoldAtts(ScaffoldAtts cm ){
        scaffoldAtts.add(cm);
    }
    @Override
    public String toString() {
        String top= new String( "new Scaffold (" )  ;
        for (int i = 0; i < scaffoldAtts.size(); i++){
            if(i == scaffoldAtts.size() - 1){
                top = top.concat(scaffoldAtts.toString()+ "\n");
            }else {
                top = top.concat(scaffoldAtts.toString()+","+ "\n");
            }
        }
        top = top.concat(")");
        return top ;
    }
}

