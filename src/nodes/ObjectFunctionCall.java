package nodes;

import org.antlr.v4.runtime.misc.Pair;
import visitors.AntlrToNode;
import visitors.SymbolTable;
import visitors.SymbolTableInstance;

public class ObjectFunctionCall extends FunctionCall {

    public String objectId;

    public ObjectFunctionCall(String objectId, Boolean await, String id, Parameters parameters){
        super(await, id, parameters);
        this.objectId = objectId;
    }
    public void SemanticCheck(String objectId ,int line){


        SymbolTableInstance symbolTableInstance1 = new SymbolTableInstance(objectId, AntlrToNode.currentNode.objectHash, "", line);
        Pair<Boolean, Integer> errorCheck1 = SymbolTable.semanticErrorsCheck(symbolTableInstance1);
        if(!errorCheck1.a){
                 AntlrToNode.semanticErrors.add("Error: variable " + objectId + " at line " + line + "is not defined");
                }
        }



    @Override
    public String toString() {
        if(await){
            return "await" + " " + objectId + "." + id + parameters.toString() + ";" ;
        }else {
            return objectId + "." + id + parameters.toString() + ";" ;
        }
    }

    @Override
    public StringBuilder astImp() {
        StringBuilder str = new StringBuilder("object function call");
        str.append("\n\t\t").append(objectId);
        str.append("\n\t\t").append(id);
        str.append("\n\t\t").append(parameters.astImp());
        return str;
    }
}
