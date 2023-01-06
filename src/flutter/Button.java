package flutter;

import java.util.ArrayList;
import java.util.List;

public class Button extends Component{
    public List<ButtonAtts> buttonAtts ;
    public Button(){
        this.buttonAtts= new ArrayList<>();
    }
    public Button(List<ButtonAtts> listt ){
        this.buttonAtts= listt;
    }
    public void addColumn_rowAtts(ButtonAtts cm ){
        this.buttonAtts.add(cm);
    }
    @Override
    public String toString() {
        String top= new String( "new Button (" )  ;
        for (int i = 0; i < buttonAtts.size(); i++) {
            if (i == buttonAtts.size() - 1) {
                top = top.concat(buttonAtts.get(i).toString() + "\n");
            } else {
                top = top.concat(buttonAtts.get(i).toString() + "," + "\n");
            }
        }
        top = top.concat(")");
        return top ;
    }
}
