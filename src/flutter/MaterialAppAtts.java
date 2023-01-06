package flutter;

import nodes.Parameters;
import java.util.ArrayList;
import java.util.List;

public class MaterialAppAtts extends Parameters {
    public List<MaterialAppAtt> atts;

    public MaterialAppAtts(List<MaterialAppAtt> atts){
        this.atts = atts;
    }

    public MaterialAppAtts(){
        atts = new ArrayList<>();
    }

    public void addAtt(MaterialAppAtt att){
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
}