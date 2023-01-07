package visitors;

import nodes.Start;
import antlr.*;

public class AntlrToStart extends DartGrammarsBaseVisitor<Start> {
    @Override
    public Start visitStart(DartGrammarsParser.StartContext ctx) {
        Start start = new Start();
        AntlrToNode nodesVisitor = new AntlrToNode();
        for(int i = 0; i < ctx.getChildCount(); i++){
            if (i == ctx.getChildCount() - 1){
                continue;
            }else {
                start.addNode(nodesVisitor.visit(ctx.getChild(i)));
            }
        }
        return start;
    }

}
