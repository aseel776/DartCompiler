package nodes;

import org.antlr.v4.runtime.misc.Pair;
import visitors.AntlrToNode;
import visitors.SymbolTable;
import visitors.SymbolTableInstance;

public class ObjectAssignment extends Assignment {
    public String objectId;

    public ObjectAssignment(String objectId, String id, Node value ){
        super(id, value);
        this.objectId = objectId;

    }
    public void SemanticCheck(String objectId, int line){
        //checking if the object is defined
        SymbolTableInstance symbolTableInstance1 = new SymbolTableInstance(objectId, AntlrToNode.currentNode.objectHash, "", line);
        Pair<Boolean, Integer> errorCheck1 = SymbolTable.semanticErrorsCheck(symbolTableInstance1);
        if (!errorCheck1.a) {
           AntlrToNode.semanticErrors.add("Error: variable " + objectId + " at line " + line + " is not defined");
        }
    }

    @Override
    public String toString() {
        return objectId + "." + id + " = " + value.toString() + ";";
    }
}
