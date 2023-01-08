package flutter;

import nodes.Node;
import nodes.Parameters;

import java.util.ArrayList;
import java.util.List;

public   class ContainerAtts extends Parameters {
    public List<ContainerAtt> containerAtt;
    public ContainerAtts(List<ContainerAtt> containerAtt) {
        this.containerAtt = containerAtt;
    }
    public ContainerAtts(){
        this.containerAtt= new ArrayList<>();
    }
    public void addAtt(ContainerAtt a){
        this.containerAtt.add(a);
    }
    @Override
    public String toString() {
        String string= "" ;
        for (int i = 0; i < containerAtt.size(); i++) {
            if (i == containerAtt.size() - 1) {
                string = string.concat(containerAtt.get(i).toString() + "\n");
            } else {
                string = string.concat(containerAtt.get(i).toString() + "," + "\n");
            }
        }
        return string;
    }
}
