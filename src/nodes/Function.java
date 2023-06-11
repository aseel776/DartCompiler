package nodes;

import org.antlr.v4.runtime.misc.Pair;
import visitors.AntlrToNode;
import visitors.SymbolTable;
import visitors.SymbolTableInstance;

public class Function extends Statement{
    public Signature signature;
    public Boolean isAsync;
    public FunctionBody functionBody;

    public Function(Signature signature, Boolean isAsync, FunctionBody functionBody){
        this.signature = signature;
        this.isAsync = isAsync;
        this.functionBody = functionBody;

    }
    public void SemanticCheck(Signature signature,int line){
        SymbolTableInstance currentElement = new SymbolTableInstance(signature.id, 0, "Function", line);
        Pair<Boolean, Integer> errorCheck = SymbolTable.semanticErrorsCheck(currentElement);
        if (errorCheck.a) {
            AntlrToNode.semanticErrors.add("Error: function " + signature.id + " at line " + line + " is already defined at line " + errorCheck.b);
        } else {
            SymbolTable.addNode(currentElement);
        }
    }

    @Override
    public String toString() {
        if(isAsync){
            return signature.toString() + " " + "async" + functionBody.toString();
        }else {
            return signature.toString() + " " + functionBody.toString();
        }
    }

    @Override
    public StringBuilder astImp() {
        StringBuilder str = new StringBuilder("function");
        str.append("\n\t\t").append(signature.astImp());
        if (isAsync) {
            str.append("\n\t\tasync");
        }
        str.append("\n\t\t").append(functionBody.astImp());
        return str;
    }
    
    // @Override
    // public String codeGenerationImp() {
    //     String str = "<?php\n";
    //     str = str.concat(signature.codeGenerationImp());
    //     str = str.concat(functionBody.codeGenerationImp());
    //     str = str.concat("\n?>");
    //     return str;
    // }
}
