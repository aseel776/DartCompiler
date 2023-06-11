package nodes;

import org.antlr.v4.runtime.misc.Pair;
import visitors.AntlrToNode;
import visitors.SymbolTable;
import visitors.SymbolTableInstance;

public class NormalDeclaration extends Declaration{

    public Boolean isLate;
    public String type;
    public Initialization init;

    public NormalDeclaration(Boolean isLate, String type, String id, Initialization init){
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
        SymbolTableInstance currentElement = new SymbolTableInstance(id, AntlrToNode.currentNode.objectHash, "Variable", line);
        Pair<Boolean, Integer> errorCheck = SymbolTable.semanticErrorsCheck(currentElement);
        if (errorCheck.a) {
            AntlrToNode.semanticErrors.add("Error: variable " + id + " at line " + line + " is already defined at line " + errorCheck.b);
        } else {
            SymbolTable.addNode(currentElement);
        }
    }


    @Override
    public String toString() {
        String normalDec = isLate? "late " : "";
        if(type != null){
            normalDec = normalDec.concat(type + " ");
        }
        normalDec = normalDec.concat(id + " ");
        if(init != null){
            normalDec = normalDec.concat(init.toString());
        }
        return normalDec;
    }

    @Override
    public StringBuilder astImp() {
        StringBuilder str = new StringBuilder("declaration");
        str.append("\n\t\t").append(this);
        return str;
    }

    // @Override
    // public String codeGenerationImp() {
    //     String str = "$" + id;
    //     if (init != null) {
    //         str = str.concat(' ' + init.codeGenerationImp());
    //     }
    //     return str;
    // }
}
