package nodes;

import org.antlr.v4.runtime.misc.Pair;
import visitors.AntlrToNode;
import visitors.SymbolTable;
import visitors.SymbolTableInstance;

public class ReturnStatement extends Node{
    public Node returnValue;

    public ReturnStatement(Node returnValue,int line){
        if(returnValue != null){
            this.returnValue = returnValue;
        }

    }
//    public void SemanticCheck(Node returnValue, int line){
//        if(returnValue instanceof  Variable){
//            SymbolTableInstance symbolTableInstance = new SymbolTableInstance(((Variable) returnValue).id, AntlrToNode.currentNode.objectHash, "", line);
//            Pair<Boolean, Integer> errorCheck = SymbolTable.semanticErrorsCheck(symbolTableInstance);
//            if (!errorCheck.a) {
//                AntlrToNode.semanticErrors.add("Error: variable " + ((Variable) returnValue).id + " at line " + line + " is not defined");
//            }}
//    }

    @Override
    public String toString() {
        if(returnValue != null) {
            return "return" + " " + returnValue.toString() + ";";
        }else {
            return "return;" ;
        }
    }

    @Override
    public StringBuilder astImp() {
        return new StringBuilder("return").append("\n\t\t").append(returnValue.astImp());
    }
}
