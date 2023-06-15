package nodes;

import org.antlr.v4.runtime.misc.Pair;
import symbolTable.SymbolTableTraveller;
import utils.Type;
import visitors.AntlrToNode;
import symbolTable.SymbolTable;
import symbolTable.SymbolTableInstance;

public class DefaultConstructor extends Node {

    public String id;
    public ConsArgs args;
    public FunctionBody consBody;

    public DefaultConstructor(String id, ConsArgs args, FunctionBody consBody){
        this.id = id;
        this.args = args;
        if(consBody != null){
            this.consBody = consBody;
        }

    }
    public void check(int line){
        Type type = Type.constructor;
        int parentHash = SymbolTableTraveller.parentNode.objectHash;
        SymbolTableInstance currentElement = new SymbolTableInstance(id, parentHash, "Constructor", line, type);
        Pair<Boolean, Integer> errorCheck = SymbolTableTraveller.checkIfDefined(currentElement);

        if (errorCheck.a) {
            AntlrToNode.semanticErrors.add("Error: constructor " + id + " at line " + line + " is already defined at line " + errorCheck.b);
        } else {
            SymbolTable.addNode(currentElement);
        }
    }


    @Override
    public String toString() {
        String cons = id + " " + args.toString();
        if(consBody != null){
            cons = cons.concat(consBody.toString());
        }else {
            cons = cons.concat(";");
        }
        return cons;
    }

    @Override
    public StringBuilder astImp() {
        StringBuilder str = new StringBuilder("default constructor");
        str.append("\n\t\t").append(id);
        str.append("\n\t\t").append(args.astImp());
        if(consBody != null){
            str.append("\n\t\t").append(consBody.astImp());
        }
        return str;
    }
}
