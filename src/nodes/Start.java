package nodes;

import java.util.ArrayList;
import java.util.List;

public class Start{

    public List<Node> nodes;

    public Start(){
        nodes = new ArrayList<>();
    }

    public void addNode(Node n){
        nodes.add(n);
    }

    @Override
    public String toString() {
        String program = "";
        for (Node n: nodes) {
            program = program.concat(n.toString() + '\n' );
        }
        return program;
    }

    public StringBuilder astImp(){
        StringBuilder start = new StringBuilder("start");
        for (Node n: nodes){
            start.append("\n\t\t").append(n.astImp());
        }
        return start;
    }
}
