package nodes;

import org.antlr.v4.runtime.misc.Pair;
import visitors.AntlrToNode;
import visitors.SymbolTable;
import visitors.SymbolTableInstance;

public class AbstractClassMethod extends ClassMethod{

    public Signature signature;

    public AbstractClassMethod(Signature signature){
        this.signature = signature;

    }
    public void SemanticCheck(Signature signature,int parentHash, int line){
        SymbolTableInstance currentElement = new SymbolTableInstance(signature.id, parentHash, "Abstract Function", line);
        Pair<Boolean, Integer> errorCheck = SymbolTable.semanticErrorsCheck(currentElement);
        if (errorCheck.a) {
            AntlrToNode.semanticErrors.add("Error: class method " + signature.id + " at line " + line + " is already defined at line " + errorCheck.b);
        } else {
            SymbolTable.addNode(currentElement);
        }
    }

    @Override
    public String toString() {
        return "abstract" + " " + signature.toString() + ';' ;
    }

    @Override
    public StringBuilder astImp() {
        StringBuilder str = new StringBuilder("abstract class method");
        str.append("\n\t\t").append("abstract");
        str.append("\n\t\t").append(signature.astImp());
        return str;
    }
}
