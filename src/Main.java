import antlr.DartGrammarsLexer;
import antlr.DartGrammarsParser;
import nodes.ForStatement;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import visitors.AntlrToNode;


public class Main {
    public static void main(String[] args){
        String source = "for(i; i<3; i+=3){}";
        CharStream input = CharStreams.fromString(source);
        DartGrammarsLexer lexer = new DartGrammarsLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        DartGrammarsParser parser = new DartGrammarsParser(tokens);
        ParseTree ast = parser.forStatement();
        //System.out.println(ast.getText());
        AntlrToNode antlrToNode = new AntlrToNode();
        ForStatement num = (ForStatement) antlrToNode.visit(ast);
        System.out.println(num.toString());
    }
}
