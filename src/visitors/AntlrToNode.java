package visitors;

import nodes.*;
import antlr.*;
import nodes.Number;
import java.util.ArrayList;
import java.util.List;

public class AntlrToNode extends DartGrammarsBaseVisitor<Node> {

    @Override
    public Node visitInteger(DartGrammarsParser.IntegerContext ctx) {
        return new DartInteger(Integer.parseInt(ctx.getText()));
    }

    @Override
    public Node visitDouble(DartGrammarsParser.DoubleContext ctx) {
        return new DartDouble(Double.parseDouble(ctx.getText()));
    }

    @Override
    public Node visitBlock(DartGrammarsParser.BlockContext ctx) {
        Block block = new Block();
        if(ctx.getChildCount() > 2){
            for(int i = 1; i < ctx.getChildCount() - 1; i++){
                block.addStatement((Statement) visit(ctx.getChild(i)));
            }
        }
        return block;
    }

    @Override
    public Node visitStatement(DartGrammarsParser.StatementContext ctx) {
        return visit(ctx.getChild(0));
    }

    @Override
    public Node visitCondition(DartGrammarsParser.ConditionContext ctx) {
        Comparison comparison = (Comparison) visit(ctx.getChild(0));
        return new Condition(comparison);
    }

    @Override
    public Node visitComparison(DartGrammarsParser.ComparisonContext ctx) {
        Variable left = new Variable(ctx.getChild(0).getText());
        Expression right = (Expression) visit(ctx.expression());
        String symbol = ctx.getChild(1).getText();
        return new Comparison(left, right, symbol);
    }

    @Override
    public Node visitIfStatement(DartGrammarsParser.IfStatementContext ctx) {
        Condition condition = (Condition) visit(ctx.getChild(2));
        Block block = (Block) visit(ctx.getChild(4));
        if(ctx.getChildCount() > 5){
            List<ElseIf> elseIfList = new ArrayList<>();
            Else anElse;
            int i = 5;
            while (ctx.getChild(i) != ctx.else_()){
                System.out.println(true);
                ElseIf anElseif = (ElseIf) visit(ctx.getChild(i));
                elseIfList.add(anElseif);
                i++;
            }
            anElse = (Else) visit(ctx.getChild(i));
            return new IfStatement(condition, block, elseIfList, anElse);
        }
        return new IfStatement(condition, block, null, null);
    }

    @Override
    public Node visitElseIf(DartGrammarsParser.ElseIfContext ctx) {
        Condition condition = (Condition) visit(ctx.getChild(2));
        Block block = (Block) visit(ctx.getChild(4));
        return new ElseIf(condition, block);
    }

    @Override
    public Node visitElse(DartGrammarsParser.ElseContext ctx) {
        return new Else((Block) visit(ctx.getChild(1)));
    }

    @Override
    public Node visitSwitchStatement(DartGrammarsParser.SwitchStatementContext ctx) {
        Variable id = new Variable(ctx.getChild(2).getText());
        SwitchBody switchBody = (SwitchBody) visit(ctx.getChild(4));
        return new SwitchStatement(id, switchBody);
    }

    @Override
    public Node visitSwitchBody(DartGrammarsParser.SwitchBodyContext ctx) {
        List<Case> cases = new ArrayList<>();
        for(int i = 1; i < ctx.getChildCount() - 2; i++){
            cases.add((Case) visit(ctx.getChild(i)));
        }
        DefaultCase defaultCase = (DefaultCase) visit(ctx.getChild(ctx.getChildCount() - 2));
        return new SwitchBody(cases, defaultCase);
    }

    @Override
    public Node visitNumberCase(DartGrammarsParser.NumberCaseContext ctx) {
        Number number = (Number) visit(ctx.getChild(1));
        CaseBody caseBody = (CaseBody) visit(ctx.getChild(3));
        return new NumberCase(number, caseBody);
    }

    @Override
    public Node visitCharCase(DartGrammarsParser.CharCaseContext ctx) {
        String chars = ctx.getChild(1).getText();
        //to replace 's, replace them with white spaces then trim att
        chars = chars.replace('\'', ' ');
        chars = chars.trim();
        CaseBody caseBody = (CaseBody) visit(ctx.getChild(3));
        return new CharCase(chars, caseBody);
    }

    @Override
    public Node visitDefaultCase(DartGrammarsParser.DefaultCaseContext ctx) {
        CaseBody caseBody = (CaseBody) visit(ctx.getChild(2));
        return new DefaultCase(caseBody);
    }

    @Override
    public Node visitCaseBody(DartGrammarsParser.CaseBodyContext ctx) {
        CaseBody caseBody = new CaseBody(false);
        for (int i = 0; i < ctx.getChildCount(); i++){
            if(ctx.getChild(i).getText().compareTo("break") == 0){
                caseBody.containsBreak = true;
            }else if(ctx.getChild(i).getText().compareTo(";") == 0){
                continue;
            }else {
                caseBody.addStatement((Statement) visit(ctx.getChild(i)));
            }
        }
        return caseBody;
    }

    @Override
    public Node visitWhileStatement(DartGrammarsParser.WhileStatementContext ctx) {
        Condition condition = (Condition) visit(ctx.condition());
        Block block = (Block) visit(ctx.block());
        return new WhileStatement(condition, block);
    }

    @Override
    public Node visitDoWhileStatement(DartGrammarsParser.DoWhileStatementContext ctx) {
        Condition condition = (Condition) visit(ctx.condition());
        Block block = (Block) visit(ctx.block());
        return new DoWhileStatement(condition, block);
    }

    @Override
    public Node visitForStatement(DartGrammarsParser.ForStatementContext ctx) {
        InitialCondition initialCondition = (InitialCondition) visit(ctx.getChild(2));
        Condition condition = (Condition) visit(ctx.getChild(4));
        Increment increment = (Increment) visit(ctx.getChild(6));
        Block block = (Block) visit(ctx.getChild(8));
        return new ForStatement(initialCondition, condition, increment, block);
    }

    @Override
    public Node visitInitialConditionDeclaration(DartGrammarsParser.InitialConditionDeclarationContext ctx) {
        String initConditionType =ctx.getChild(0).getText();
        String id = ctx.getChild(1).getText();
        Expression value = (Expression) visit(ctx.getChild(3));
        return new InitialConditionDeclaration(initConditionType, id, value);
    }

    @Override
    public Node visitInitialConditionAssignment(DartGrammarsParser.InitialConditionAssignmentContext ctx) {
        Variable id = new Variable(ctx.getChild(0).getText());
        Expression value = (Expression) visit(ctx.getChild(2));
        return new InitialConditionAssignment(id, value);
    }

    @Override
    public Node visitInitialConditionVariable(DartGrammarsParser.InitialConditionVariableContext ctx) {
        Variable id = new Variable(ctx.getText());
        return new InitialConditionVariable(id);
    }

    @Override
    public Node visitIncrement(DartGrammarsParser.IncrementContext ctx) {
        Variable id = new Variable(ctx.getChild(0).getText());
        String symbol = ctx.getChild(1).getText();
        Expression expression = (Expression) visit(ctx.getChild(2));
        return new Increment(id, symbol, expression);
    }

    @Override
    public Node visitForeachStatement(DartGrammarsParser.ForeachStatementContext ctx) {
        String type =  ctx.varOrType().getText();
        String id = ctx.getChild(3).getText();
        Variable list = new Variable(ctx.getChild(5).getText());
        Block block = (Block) visit(ctx.block());
        return new ForeachStatement(type, id, list, block);
    }

    @Override
    public Node visitFinalDeclarartion(DartGrammarsParser.FinalDeclarartionContext ctx) {
        boolean late = (ctx.LATE() != null);
        String type = null;
        if(ctx.type() != null){
            type = ctx.type().getText();
        }
        String id = ctx.ID().getText();
        Initialization init= null ;
        if(ctx.initialization() != null){
            init = (Initialization) visit(ctx.initialization());
        }
        return new FinalDeclaration(late, type, id, init);
    }

    @Override
    public Node visitConstDeclarartion(DartGrammarsParser.ConstDeclarartionContext ctx) {
        String type = null;
        if(ctx.type() != null){
            type= ctx.type().getText();
        }
        String id = ctx.ID().getText();
        Initialization init = (Initialization) visit(ctx.initialization());
        return new ConstDeclaration(type, id, init);
    }

    @Override
    public Node visitNormalDeclarartion(DartGrammarsParser.NormalDeclarartionContext ctx) {
        boolean late = (ctx.LATE() != null);
        String type = null;
        if(ctx.varOrType() != null){
            type = ctx.varOrType().getText();
        }
        String id = ctx.ID().getText();
        Initialization init= null ;
        if(ctx.initialization() != null){
                init = (Initialization) visit(ctx.initialization());
        }
        return new NormalDeclaration(late, type, id, init);
    }

    @Override
    public Node visitInitialization(DartGrammarsParser.InitializationContext ctx) {
        if(ctx.getChild(1) == ctx.ID()){
            Variable variable = new Variable(ctx.ID().getText());
            return new Initialization(variable);
        } else if (ctx.getChild(1) == ctx.CHARACTERS()) {
            Characters chars = new Characters(ctx.CHARACTERS().getText());
            return new Initialization(chars);
        }else{
            Node node = (Node) visit(ctx.getChild(1));
            return new Initialization(node);
        }
    }

    @Override
    public Node visitAssign(DartGrammarsParser.AssignContext ctx) {
        String id = ctx.getChild(0).getText();
        if(ctx.getChild(2) == ctx.ID(1)){
            Variable variable = new Variable(ctx.getChild(2).getText());
            return new Assignment(id, variable);
        } else if (ctx.getChild(2) == ctx.CHARACTERS()) {
            Characters chars = new Characters(ctx.getChild(2).getText());
            return new Assignment(id, chars);
        }else{
            Node node = visit(ctx.getChild(2));
            return new Assignment(id, node);
        }
    }

    @Override
    public Node visitObjectAssign(DartGrammarsParser.ObjectAssignContext ctx) {
        String objectId = ctx.getChild(0).getText();
        String id = ctx.getChild(2).getText();
        if(ctx.getChild(4) == ctx.ID(2)){
            Variable variable = new Variable(ctx.getChild(4).getText());
            return new ObjectAssignment(objectId, id, variable);
        } else if (ctx.getChild(4) == ctx.CHARACTERS()) {
            Characters chars = new Characters(ctx.getChild(4).getText());
            return new ObjectAssignment(objectId, id, chars);
        }else{
            Node node = visit(ctx.getChild(4));
            return new ObjectAssignment(objectId, id, node);
        }
    }

    @Override
    public Node visitThisAssign(DartGrammarsParser.ThisAssignContext ctx) {
        String id = ctx.getChild(2).getText();
        if(ctx.getChild(4) == ctx.ID(1)){
            Variable variable = new Variable(ctx.getChild(4).getText());
            return new ThisStatement(id, variable);
        } else if (ctx.getChild(4) == ctx.CHARACTERS()) {
            Characters chars = new Characters(ctx.getChild(4).getText());
            return new ThisStatement(id, chars);
        }else{
            Node node = visit(ctx.getChild(4));
            return new ThisStatement(id, node);
        }
    }

    @Override
    public Node visitList(DartGrammarsParser.ListContext ctx) {
        ListType list = new ListType();
        int idCounter = 0;
        int charsCounter = 0;
        for(int i = 1; i < ctx.getChildCount() - 1; i+=2){
            if(ctx.getChild(i) == ctx.ID(idCounter)){
                Variable variable = new Variable(ctx.getChild(i).getText());
                list.addElement(variable);
                idCounter++;
            } else if (ctx.getChild(i) == ctx.CHARACTERS(charsCounter)) {
                Characters chars = new Characters(ctx.getChild(i).getText());
                list.addElement(chars);
                charsCounter++;
            }else{
                list.addElement(visit(ctx.getChild(i)));
            }
        }
        return list;
    }

    @Override
    public Node visitMultiplicationExpression(DartGrammarsParser.MultiplicationExpressionContext ctx) {
        Expression left = (Expression) visit(ctx.getChild(0));
        Expression right = (Expression) visit(ctx.getChild(2));
        return new MultiplicationExpression(left,right);
    }

    @Override
    public Node visitDivisionExpression(DartGrammarsParser.DivisionExpressionContext ctx) {
        Expression left = (Expression) visit(ctx.getChild(0));
        Expression right = (Expression) visit(ctx.getChild(2));
        return new DivisionExpression(left,right);
    }

    @Override
    public Node visitAddtitionExpression(DartGrammarsParser.AddtitionExpressionContext ctx) {
        Expression left = (Expression) visit(ctx.getChild(0));
        Expression right = (Expression) visit(ctx.getChild(2));
        return new AdditionExpression(left,right);
    }

    @Override
    public Node visitSubtractExpression(DartGrammarsParser.SubtractExpressionContext ctx) {
        Expression left = (Expression) visit(ctx.getChild(0));
        Expression right = (Expression) visit(ctx.getChild(2));
        return new SubtractExpression(left,right);
    }

    @Override
    public Node visitNumberExpression(DartGrammarsParser.NumberExpressionContext ctx) {
        return visit(ctx.getChild(0));
    }
    @Override
    public Node visitVariableExpression(DartGrammarsParser.VariableExpressionContext ctx) {
        return new Variable(ctx.getChild(0).getText());
    }
}
