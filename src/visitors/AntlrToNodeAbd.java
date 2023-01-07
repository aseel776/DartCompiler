package visitors;
import antlr.*;
import nodes.*;

import java.util.List;

public class AntlrToNodeAbd extends DartGrammarsBaseVisitor<Node> {
    @Override
    public Node visitZeroArguments(DartGrammarsParser.ZeroArgumentsContext ctx) {

        return new ZeroArguments();
    }

    @Override
    public Node visitArg(DartGrammarsParser.ArgContext ctx) {
        String type=null;
        if(ctx.type()!=null){
            type= String.valueOf(ctx.type().getChild(0).getText()); }
        String ID = ctx.ID().getChild(1).getText();
        return new Argument(type,ID);
    }

    @Override
    public Node visitPositionalArguments(DartGrammarsParser.PositionalArgumentsContext ctx) {
        List<Argument> arguments =  null;
        for (int i =0 ; i< ctx.arg().size() ; i++){
            arguments.add((Argument) visit(ctx.arg(i)));
        }
        return new PositionalArguments(arguments);
    }

    @Override
    public Node visitNamedArguments(DartGrammarsParser.NamedArgumentsContext ctx) {
        List<NamedArgument> namedArguments =  null;
        for (int i =0 ; i< ctx.arg().size() ; i++){
            namedArguments.add((NamedArgument) visit(ctx.arg(i)));
        }
        return new NamedArguments(namedArguments);
    }

    @Override
    public Node visitPositionalNamedArguments(DartGrammarsParser.PositionalNamedArgumentsContext ctx) {
        PositionalArguments positionalArguments = (PositionalArguments) visit(ctx.getChild(0));
        NamedArguments namedArguments = (NamedArguments) visit(ctx.getChild(2));
        return new PositionalNamedArguments(positionalArguments,namedArguments);
    }

    @Override
    public Node visitSignature(DartGrammarsParser.SignatureContext ctx) {
        String voidOrType=null;
        if(ctx.voidOrType()!=null){
            voidOrType= String.valueOf(ctx.voidOrType().getChild(0).getText());
        }
        String ID = ctx.ID().getChild(1).getText();
        Arguments arguments=(Arguments) visit(ctx.getChild(3));

        return new Signature(voidOrType,ID,arguments);
    }
    @Override
    public Node visitReturnStatement(DartGrammarsParser.ReturnStatementContext ctx) {
        Node node= (Node) visit(ctx.getChild(1));
        return new ReturnStatement(node);
    }

    @Override
    public Node visitFunctionBody(DartGrammarsParser.FunctionBodyContext ctx) {
        List<Statement> statements =null;
        for (int i =0 ; i< ctx.statement().size() ; i++){
            statements.add((Statement) visit(ctx.statement(i)));
        }
        ReturnStatement returnStatement=(ReturnStatement) visit(ctx.returnStatement().getChild(2));

        return new FunctionBody(statements,returnStatement);
    }

    @Override
    public Node visitFunction(DartGrammarsParser.FunctionContext ctx) {
        Signature signature = (Signature) visit(ctx.signature().getChild(0));
        boolean ASYNC;
        if(ctx.ASYNC()!=null){
            ASYNC =true;
        }
        else {
            ASYNC = false;
        }
        FunctionBody functionBody = (FunctionBody) visit(ctx.functionBody().getChild(2));
            return new Function(signature,ASYNC,functionBody);
    }

    @Override
    public Node visitUnnamedFunction(DartGrammarsParser.UnnamedFunctionContext ctx) {
        Arguments arguments=(Arguments) visit(ctx.getChild(1));
        boolean ASYNC;
        if(ctx.ASYNC()!=null){
            ASYNC =true;
        }
        else {
            ASYNC = false;
        }
        FunctionBody functionBody = (FunctionBody) visit(ctx.functionBody().getChild(4));
        return new UnnamedFunction(arguments,ASYNC,functionBody);
    }
}
