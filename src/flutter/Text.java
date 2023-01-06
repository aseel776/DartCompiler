package flutter;

import java.util.ArrayList;
import java.util.List;

public class Text extends Component{
    public List<TextAtts> textAtts ;
    public String character;
    public Text(String character){
        this.textAtts= new ArrayList<>();
        this.character=character;
    }
    public Text(List<TextAtts> listt,String character ){
        this.textAtts= listt;
        this.character=character;

    }
    public void addTextAtts(TextAtts cm ){
        textAtts.add(cm);
    }
    @Override
    public String toString() {
        String top= new String( "new Text (" )  ;
        top.concat(character);
        top.concat(",");
        for (int i = 0; i < textAtts.size(); i++) {
            if (i == textAtts.size() - 1) {
                top = top.concat(textAtts.get(i).toString() + "\n");
            } else {
                top = top.concat(textAtts.get(i).toString() + "," + "\n");
            }
        }
        top = top.concat(")");
        return top ;
    }
}
//    NEW TEXT '(' CHARACTERS COMMA? textAtts* ')'

// new Text ("character,List)