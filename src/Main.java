import antlr.DartGrammarsLexer;
import antlr.DartGrammarsParser;
import flutter.MaterialApp;
import flutter.Row;
import flutter.Stack;
import flutter.Text;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import visitors.AntlrToNode;


public class Main {
    public static void main(String[] args){
        String source = "new Text('aseel', textColor: Red, textStyle: Italic, textSize: 23)";
        CharStream input = CharStreams.fromString(source);
        DartGrammarsLexer lexer = new DartGrammarsLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        DartGrammarsParser parser = new DartGrammarsParser(tokens);
        ParseTree ast = parser.text();
        AntlrToNode antlrToNode = new AntlrToNode();
        Text num = (Text) antlrToNode.visit(ast);
        System.out.println(num.toString());
    }
}
