import antlr.DartGrammarsLexer;
import antlr.DartGrammarsParser;
import nodes.*;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import visitors.AntlrToStart;


public class Main {
    public static void main(String[] args){
        String source = "";
        CharStream input = CharStreams.fromString(source);
        //CharStream input = CharStreams.fromFileName(source);
        DartGrammarsLexer lexer = new DartGrammarsLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        DartGrammarsParser parser = new DartGrammarsParser(tokens);
        ParseTree ast = parser.start();
        AntlrToStart startVisitor = new AntlrToStart();
        Start program = startVisitor.visit(ast);
        System.out.println(program.toString());
    }
}
