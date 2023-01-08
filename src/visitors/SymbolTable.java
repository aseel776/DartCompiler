package visitors;
import org.antlr.v4.codegen.model.SrcOp;
import org.antlr.v4.runtime.misc.Pair;

import java.util.*;

public class SymbolTable {
    private static final List<Pair<String, Pair<String, Integer>>> table = new ArrayList<>();

    public static void addNode(String id, Pair<String, Integer> value){
        table.add(new Pair<>(id, value));
    }

    public static void replaceNode(String id, Pair<String, Integer> oldValue, Pair<String, Integer> newValue){
        table.remove(new Pair<>(id, oldValue));
        table.add(new Pair<>(id, newValue));
    }

    public static String getTable(){
        String str = "---------------\n";
        table.sort(Comparator.comparing(o -> (o.b.b)));
        for (Pair<String, Pair<String, Integer>> pair: table){
            str = str.concat(pair.a + ":\n" + pair.b.a + " at line " + pair.b.b + "\n---------------\n");
        }
        return str;
    }
}
