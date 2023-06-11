package nodes;

import org.antlr.v4.runtime.misc.Pair;
import visitors.AntlrToNode;
import visitors.SymbolTable;
import visitors.SymbolTableInstance;

public class FunctionCall extends Statement{

    public Boolean await;
    public String id;
    public Parameters parameters;

    public FunctionCall(Boolean await, String id, Parameters parameters){
        this.await = await;
        this.id = id;
        this.parameters = parameters;

    }
    public void SemanticCheck(String id, int line){
        //checking if the function is defined
        SymbolTableInstance symbolTableInstance2 = new SymbolTableInstance(id, 0, "", line);
        Pair<Boolean, Integer> errorCheck2 = SymbolTable.semanticErrorsCheck(symbolTableInstance2);
        if(!errorCheck2.a){
            AntlrToNode.semanticErrors.add("Error: function " + id + " at line " + line + " is not defined");
        }
    }


    @Override
    public String toString() {
        if(await){
            return "await" + " " + id + parameters.toString() + ";" ;
        }else {
            return id + parameters.toString() + ";" ;
        }
    }

    @Override
    public StringBuilder astImp() {
        StringBuilder str = new StringBuilder("function call");
        if(await){
            str.append("\n\t\tawait");
        }
        str.append("\n\t\t").append(id);
        str.append("\n\t\t").append(parameters.astImp());
        return str;
    }
}
