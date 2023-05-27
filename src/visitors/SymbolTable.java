package visitors;

import org.antlr.v4.runtime.misc.Pair;

import java.util.*;


public class SymbolTable {
    //    public static final List<Pair<Pair<String,Integer>, Pair<String, Integer>>> table = new ArrayList<>();
    //مؤقت بس مشان اقدر جربو قبل ما ضيفو ع SymbolTable (table)
//    public static final Map<String,Integer> ParentHash=new HashMap();
    public static final List<SymbolTableInstance> symbolTable = new ArrayList<>();
//    public static List<SymbolTableInstance> getVariables(String id){
//        List<SymbolTableInstance> list;
//        for(SymbolTableInstance Node: symbolTable){
//
//        }
//    }


    public static Pair<Boolean, Integer> semanticErrorsCheck(SymbolTableInstance currentNode) {
        int variableDeclarationLine = 0;
        for (SymbolTableInstance Node : symbolTable) {

            if (currentNode.id.equals(Node.id)) {

                if (currentNode.parentHash.equals(Node.parentHash)) {

                    variableDeclarationLine = Node.declarationLineNumber;
                    return new Pair<>(true, variableDeclarationLine);
                }
            }
        }
        return new Pair(false, variableDeclarationLine);
    }

    public static void addNode(SymbolTableInstance newNode) {
        symbolTable.add(newNode);
    }

    public static void replaceNode(SymbolTableInstance oldValue, SymbolTableInstance newValue) {
        symbolTable.remove(oldValue);
        symbolTable.add(newValue);
    }


}