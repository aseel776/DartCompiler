package nodes;

import java.util.List;
import java.util.ArrayList;

public class Block extends Node{
    public List<Statement> statements;

    public Block(){
        statements = new ArrayList<>();
    }

    public void addStatement(Statement s){
        statements.add(s);
    }

    @Override
    public String toString() {
        String block = new String("{");
        for (Node n : statements) {
            block = block.concat('\n' + n.toString());
        }
        block = block.concat("\n }");
        return block;
    }
}