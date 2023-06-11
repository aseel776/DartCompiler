package nodes;

import org.antlr.v4.runtime.misc.Pair;
import visitors.AntlrToNode;
import visitors.SymbolTable;
import visitors.SymbolTableInstance;

public class Variable extends Expression{

    public String id;

    public Variable(String id){
        this.id = id;

    }
    public void SemanticCheck(String id, int line){
        //checking if the variable is defined
        SymbolTableInstance symbolTableInstance = new SymbolTableInstance(id, AntlrToNode.currentNode.objectHash, "", line);
        Pair<Boolean, Integer> errorCheck = SymbolTable.semanticErrorsCheck(symbolTableInstance);
        if (!errorCheck.a) {
            AntlrToNode.semanticErrors.add("Error: variable " + id + " at line " + line + " is not defined");
        }
    }

    @Override
    public String toString() {
        return id;
    }

    @Override
    public StringBuilder astImp() {
        return new StringBuilder("variable").append("\n\t\t").append(id);
    }
}
