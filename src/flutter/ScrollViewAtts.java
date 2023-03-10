package flutter;

import nodes.Parameters;
import java.util.ArrayList;
import java.util.List;

public class ScrollViewAtts extends Parameters {

    public List<ScrollViewAtt> atts;

    public ScrollViewAtts(List<ScrollViewAtt> atts){
        this.atts = atts;
    }

    public ScrollViewAtts(){
        atts = new ArrayList<>();
    }

    public void addAtt(ScrollViewAtt att){
        atts.add(att);
    }

    @Override
    public String toString() {
        String top = "";
        for (int i = 0; i < atts.size(); i++) {
            if (i == atts.size() - 1) {
                top = top.concat(atts.get(i).toString() + "\n");
            } else {
                top = top.concat(atts.get(i).toString() + "," + "\n");
            }
        }
        return top;
    }

    @Override
    public StringBuilder astImp() {
        StringBuilder str = new StringBuilder("scroll view atts");
        for(ScrollViewAtt att: atts){
            str.append("\n\t\t").append(att.astImp());
        }
        return str;
    }
}
