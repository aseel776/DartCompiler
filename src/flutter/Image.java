package flutter;

import java.util.ArrayList;
import java.util.List;

public class Image extends Component{
    public List<ImageAtts> imageAtts ;
    public String character;
    public Image(String character){
        this.imageAtts= new ArrayList<>();
        this.character=character;
    }
    public Image(List<ImageAtts> listt,String character ){
        this.imageAtts= listt;
        this.character=character;

    }
    public void addImageAtts(ImageAtts cm ){
        imageAtts.add(cm);
    }
    @Override
    public String toString() {
        String top= new String( "new Image (" )  ;
        top.concat(character);
        top.concat(",");
        for (int i = 0; i < imageAtts.size(); i++) {
            if (i == imageAtts.size() - 1) {
                top = top.concat(imageAtts.toString() + "\n");
            } else {
                top = top.concat(imageAtts.toString() + "," + "\n");
            }
        }
        top = top.concat(")");
        return top ;
    }
}
//    NEW TEXT '(' CHARACTERS COMMA? textAtts* ')'

// new Text ("character,List)