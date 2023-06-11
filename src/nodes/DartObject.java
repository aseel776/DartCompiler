package nodes;

import org.antlr.v4.runtime.misc.Pair;
import visitors.AntlrToNode;
import visitors.SymbolTable;
import visitors.SymbolTableInstance;

public class DartObject extends Node {

    public String id;
    public Parameters parameters;

    public DartObject(String id, Parameters parameters){
        this.id = id;
        this.parameters = parameters;

    }
    public void SemanticCheck(String id, int line){
        //checking if the class is defined
        SymbolTableInstance symbolTableInstance = new SymbolTableInstance(id, 0, "", line);
        Pair<Boolean, Integer> errorCheck = SymbolTable.semanticErrorsCheck(symbolTableInstance);
        if (!errorCheck.a) {
            AntlrToNode.semanticErrors.add("Error: class " + id + " at line " + line + " is not defined");
        }
    }

    @Override
    public String toString() {
        return "new" + " " + id + parameters.toString();
    }

    @Override
    public StringBuilder astImp() {
        StringBuilder str = new StringBuilder("object");
        str.append("\n\t\t").append(id);
        str.append("\n\t\t").append(parameters.astImp());
        return str;
    }
}