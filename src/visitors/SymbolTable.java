package visitors;

import org.antlr.v4.runtime.misc.Pair;

import java.util.*;


public class SymbolTable {

    public static final List<SymbolTableInstance> symbolTable = new ArrayList<>();

    public static Pair<Boolean, Integer> semanticErrorsCheck(SymbolTableInstance currentNode) {
        int variableDeclarationLine = 0;
        for (SymbolTableInstance Node : symbolTable) {
            if (currentNode.id.equals(Node.id)) {
                if (currentNode.parentHash == Node.parentHash) {
                    variableDeclarationLine = Node.declarationLineNumber;
                    return new Pair<>(true, variableDeclarationLine);
                }
            }
        }
        return new Pair<>(false, variableDeclarationLine);
    }

    public static void addNode(SymbolTableInstance newNode) {
        symbolTable.add(newNode);
    }

    public static void replaceNode(SymbolTableInstance oldValue, SymbolTableInstance newValue) {
        for (SymbolTableInstance s: symbolTable) {
            if(s.equals(oldValue)){
                symbolTable.remove(s);
                symbolTable.add(newValue);
                break;
            }
        }
    }

    public static void printSymbolTable(){
        symbolTable.sort(Comparator.comparing(o -> o.declarationLineNumber));
        for (SymbolTableInstance s: symbolTable) {
            System.out.println(s.toString());
            System.out.println("-----");
        }
    }

}