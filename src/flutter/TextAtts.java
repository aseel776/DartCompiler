package flutter;

import nodes.Parameters;

import java.util.ArrayList;
import java.util.List;

public  class TextAtts extends Parameters {

    public List<TextAtt> textAtt;

    public  TextAtts(List<TextAtt>textAtt){
        this.textAtt=textAtt;
    }

    public  TextAtts(){
        this.textAtt= new ArrayList<>();
    }
    public void addAtt(TextAtt textAtt){
        this.textAtt.add(textAtt);
    }

    @Override
    public String toString() {
        String top="" ;
        for (int i = 0; i < textAtt.size(); i++) {
            if (i == textAtt.size() - 1) {
                top = top.concat(textAtt.get(i).toString() + "\n");
            } else {
                top = top.concat(textAtt.get(i).toString() + "," + "\n");
            }
        }
        return top ;
    }
}
