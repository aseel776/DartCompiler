import antlr.DartGrammarsLexer;
import antlr.DartGrammarsParser;
import nodes.*;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import visitors.AntlrToNode;


public class Main {
    public static void main(String[] args){
        String source = "void x()async{ z.i = x; return x;}";
        CharStream input = CharStreams.fromString(source);
        DartGrammarsLexer lexer = new DartGrammarsLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        DartGrammarsParser parser = new DartGrammarsParser(tokens);
        ParseTree ast = parser.function();
        //System.out.println(ast.getText());
        AntlrToNode antlrToNode = new AntlrToNode();
        Function num = (Function) antlrToNode.visit(ast);
        System.out.println(num.toString());
    }
}
