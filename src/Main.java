import nodes.*;
import java.io.IOException;
import visitors.SymbolTable;
import visitors.AntlrToStart;
import antlr.DartGrammarsLexer;
import antlr.DartGrammarsParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.CommonTokenStream;


public class Main {
    public static void main(String[] args){
        String source = "tests/test3.txt";
        CharStream input;
        try {
            input = CharStreams.fromFileName(source);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        DartGrammarsLexer lexer = new DartGrammarsLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        DartGrammarsParser parser = new DartGrammarsParser(tokens);
        ParseTree ast = parser.start();
        AntlrToStart startVisitor = new AntlrToStart();
        Start program = startVisitor.visit(ast);
        System.out.println("---AST---");
        System.out.print(program.astImp());
        System.out.println();
        System.out.println();
        System.out.println("---Symbol Table---");
        System.out.println(SymbolTable.getTable());
    }
}
