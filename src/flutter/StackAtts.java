package flutter;

import nodes.Node;
import nodes.Parameters;

import java.util.ArrayList;
import java.util.List;

public  class StackAtts extends Parameters {

    public List<StackAtt> stackAtt;
    public  StackAtts(List<StackAtt>stackAtt){
        this.stackAtt=stackAtt;
    }

    public  StackAtts(){
        this.stackAtt= new ArrayList<>();
    }
    public  void addAtt(StackAtt stackAtt){
        this.stackAtt.add(stackAtt);
    }

    @Override
    public String toString() {
        String top="" ;
        for (int i = 0; i < stackAtt.size(); i++) {
            if (i == stackAtt.size() - 1) {
                top = top.concat(stackAtt.get(i).toString() + "\n");
            } else {
                top = top.concat(stackAtt.get(i).toString() + "," + "\n");
            }
        }
        return top ;
    }
}
