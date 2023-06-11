package nodes;

import org.antlr.v4.runtime.misc.Pair;
import visitors.AntlrToNode;
import visitors.SymbolTable;
import visitors.SymbolTableInstance;

public class FinalDeclaration extends Declaration{
    public Boolean isLate;
    public String type;
    public Initialization init;

    public FinalDeclaration(Boolean isLate, String  type, String id, Initialization init){
        super(id);
        this.isLate = isLate;
        if(type != null){
            this.type = type;
        }
        if(init != null){
            this.init = init;
        }

    }
    public void SemanticCheck(String type , String id, int line){
        SymbolTableInstance currentElement = new SymbolTableInstance(id, AntlrToNode.currentNode.objectHash, "Final Variable", line);
        Pair<Boolean, Integer> errorCheck = SymbolTable.semanticErrorsCheck(currentElement);
        if (errorCheck.a) {
            AntlrToNode.semanticErrors.add("Error: final variable " + id + " at line " + line + " is already defined at line " + errorCheck.b);
        } else {
            SymbolTable.addNode(currentElement);
        }
    }

    @Override
    public String toString() {
        String finalDec = isLate? "late final " : "final ";
        if(type != null){
            finalDec = finalDec.concat(type + " ");
        }
        finalDec = finalDec.concat(id + " ");
        if(init != null){
            finalDec = finalDec.concat(init.toString());
        }
        return finalDec;
    }

    @Override
    public StringBuilder astImp() {
        StringBuilder str = new StringBuilder("declaration");
        str.append("\n\t\t").append(this);
        return str;
    }
}
