package flutter;


import nodes.Parameters;
import java.util.ArrayList;
import java.util.List;

public class SizedBoxAtts extends Parameters {
    public List<SizedBoxAtt> atts;

    public SizedBoxAtts(List<SizedBoxAtt> atts){
        this.atts = atts;
    }

    public SizedBoxAtts(){
        atts = new ArrayList<>();
    }

    public void addAtt(SizedBoxAtt att){
        atts.add(att);
    }

    @Override
    public String toString() {
        String top ="";
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
