package nodes;

import org.antlr.v4.runtime.misc.Pair;
import visitors.AntlrToNode;
import visitors.SymbolTable;
import visitors.SymbolTableInstance;

public class StaticClassMethod extends ClassMethod{

    public Signature signature;
    public Boolean isAsync;
    public FunctionBody methodBody;

    public StaticClassMethod(Signature signature, Boolean isAsync, FunctionBody methodBody){
        this.signature = signature;
        this.isAsync = isAsync;
        this.methodBody = methodBody;

    }
    public void SemanticCheck(Signature signature,int parentHash, int line){
        SymbolTableInstance currentElement = new SymbolTableInstance(signature.id, parentHash, "Static Class Method", line);
        Pair<Boolean, Integer> errorCheck = SymbolTable.semanticErrorsCheck(currentElement);
        if (errorCheck.a) {
            AntlrToNode.semanticErrors.add("Error: class method " + signature.id + " at line " + line + " is already defined at line " + errorCheck.b);
        } else {
            SymbolTable.addNode(currentElement);
        }
    }

    @Override
    public String toString() {
        String method = "static" + " " + signature.toString() + " ";
        if(isAsync){
            method = method.concat("async");
        }
        method = method.concat(methodBody.toString());
        return method;
    }

    @Override
    public StringBuilder astImp() {
        StringBuilder str = new StringBuilder("static class method");
        str.append("\n\t\t").append(signature.astImp());
        if(isAsync){
            str.append("\n\t\tasync");
        }
        str.append("\n\t\t").append(methodBody.astImp());
        return str;
    }
}
