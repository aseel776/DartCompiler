package nodes;

import org.antlr.v4.runtime.misc.Pair;
import visitors.AntlrToNode;
import visitors.SymbolTable;
import visitors.SymbolTableInstance;

public class Initialization extends Node{

    public Node value;

    public Initialization(Node value){
        this.value = value;
    }

    @Override
    public String toString() {
        return "= " + value.toString();
    }

    @Override
    public StringBuilder astImp() {
        return new StringBuilder("initialization").append("\n\t\t").append(value.astImp());
    }

    // @Override
    // public String codeGenerationImp() {
    //     String str = "= ";
    //     str = str.concat(value.codeGenerationImp());
    //     return str;
    // }
}
