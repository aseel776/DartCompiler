package nodes;

import org.antlr.v4.runtime.misc.Pair;
import visitors.AntlrToNode;
import visitors.SymbolTable;
import visitors.SymbolTableInstance;

public class ConstDeclaration extends Declaration{

    public String type;
    public Initialization init;

    public ConstDeclaration(String type, String id, Initialization init){
        super(id);
        if(type != null){
            this.type = type;
        }
        this.init = init;
    }
    public void SemanticCheck(String type , String id, int line){
        SymbolTableInstance currentElement = new SymbolTableInstance(id, AntlrToNode.currentNode.objectHash, "Const Variable", line);
        Pair<Boolean, Integer> errorCheck = SymbolTable.semanticErrorsCheck(currentElement);
        if (errorCheck.a) {
            AntlrToNode.semanticErrors.add("Error: const variable " + id + " at line " + line + " is already defined at line " + errorCheck.b);
        } else {
            SymbolTable.addNode(currentElement);
        }
    }

    @Override
    public String toString() {
        if(type != null){
            return "const " + type + " " + id + " " + init.toString();
        }else {
            return "const " + id + " " + init.toString();
        }
    }

    @Override
    public StringBuilder astImp() {
        StringBuilder str = new StringBuilder("declaration");
        str.append("\n\t\t").append(this);
        return str;
    }
}
