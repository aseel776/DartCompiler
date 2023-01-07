import antlr.DartGrammarsLexer;
import antlr.DartGrammarsParser;
import flutter.MaterialApp;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import visitors.AntlrToNode;


public class Main {
    public static void main(String[] args){
        String source = "new MaterialApp(title:'ccc')";
        CharStream input = CharStreams.fromString(source);
        DartGrammarsLexer lexer = new DartGrammarsLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        DartGrammarsParser parser = new DartGrammarsParser(tokens);
        ParseTree ast = parser.materialApp();
        AntlrToNode antlrToNode = new AntlrToNode();
        MaterialApp num = (MaterialApp) antlrToNode.visit(ast);
        System.out.println(num.toString());
    }
}
