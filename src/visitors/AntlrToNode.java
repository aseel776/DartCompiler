package visitors;

import flutter.*;
import nodes.*;
import antlr.*;
import nodes.Number;
import org.antlr.v4.runtime.misc.Pair;

import java.util.ArrayList;
import java.util.List;

public class AntlrToNode extends DartGrammarsBaseVisitor<Node> {

    List<String> semanticErrors;
    Node currentNode;
    Node parentNode;


    public AntlrToNode(List<String> semanticErrors) {
        this.semanticErrors = semanticErrors;
    }

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
        //to fix or remove later
        //currentNode = block;
        //currentNode.objectHash = block.hashCode();
        if (ctx.getChildCount() > 2) {
            for (int i = 1; i < ctx.getChildCount() - 1; i++) {
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
        int line = ctx.start.getLine();
        Variable left = new Variable(ctx.getChild(0).getText());
        //checking if the variable is defined
        SymbolTableInstance symbolTableInstance = new SymbolTableInstance(left.id, currentNode.objectHash, "", line);
        Pair<Boolean, Integer> errorCheck = SymbolTable.semanticErrorsCheck(symbolTableInstance);
        if (!errorCheck.a) {
            semanticErrors.add("Error: variable " + left.id + " at line " + line + " is not defined");
        }
        Expression right = (Expression) visit(ctx.expression());
        String symbol = ctx.getChild(1).getText();
        return new Comparison(left, right, symbol);
    }

    @Override
    public Node visitIfStatement(DartGrammarsParser.IfStatementContext ctx) {
        Condition condition = (Condition) visit(ctx.getChild(2));
        Block block = (Block) visit(ctx.getChild(4));
        if (ctx.getChildCount() > 5) {
            List<ElseIf> elseIfList = new ArrayList<>();
            Else anElse;
            int i = 5;
            while (ctx.getChild(i) != ctx.else_()) {
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
        Block block = (Block) visit(ctx.getChild(1));
        return new Else(block);
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
        for (int i = 1; i < ctx.getChildCount() - 2; i++) {
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
        // to replace 's, replace them with white spaces then trim att
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
        //to fix or remove later
        //currentNode = caseBody;
        //currentNode.objectHash = caseBody.hashCode();
        for (int i = 0; i < ctx.getChildCount(); i++) {
            if (ctx.getChild(i).getText().compareTo("break") == 0) {
                caseBody.containsBreak = true;
            } else if (ctx.getChild(i).getText().compareTo(";") == 0) {
                continue;
            } else {
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
        String initConditionType = ctx.getChild(0).getText();
        String id = ctx.getChild(1).getText();
        Expression value = (Expression) visit(ctx.getChild(3));
        return new InitialConditionDeclaration(initConditionType, id, value);
    }

    @Override
    public Node visitInitialConditionAssignment(DartGrammarsParser.InitialConditionAssignmentContext ctx) {
        Variable id = new Variable(ctx.getChild(0).getText());
        int line = ctx.start.getLine();
        //checking if the variable is defined
        SymbolTableInstance symbolTableInstance = new SymbolTableInstance(id.id, currentNode.objectHash, "", line);
        Pair<Boolean, Integer> errorCheck = SymbolTable.semanticErrorsCheck(symbolTableInstance);
        if (!errorCheck.a) {
            semanticErrors.add("Error: variable " + id.id + " at line " + line + " is not defined");
        }
        Expression value = (Expression) visit(ctx.getChild(2));
        return new InitialConditionAssignment(id, value);
    }

    @Override
    public Node visitInitialConditionVariable(DartGrammarsParser.InitialConditionVariableContext ctx) {
        Variable id = new Variable(ctx.getText());
        int line = ctx.start.getLine();
        //checking if the variable is defined
        SymbolTableInstance symbolTableInstance = new SymbolTableInstance(id.id, currentNode.objectHash, "", line);
        Pair<Boolean, Integer> errorCheck = SymbolTable.semanticErrorsCheck(symbolTableInstance);
        if (!errorCheck.a) {
            semanticErrors.add("Error: variable " + id.id + " at line " + line + " is not defined");
        }
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
        String type = ctx.varOrType().getText();
        String id = ctx.getChild(3).getText();
        Variable list = new Variable(ctx.getChild(5).getText());
        Block block = (Block) visit(ctx.block());
        return new ForeachStatement(type, id, list, block);
    }


    @Override
    public Node visitFinalDeclarartion(DartGrammarsParser.FinalDeclarartionContext ctx) {
        boolean late = (ctx.LATE() != null);
        String type = null;
        if (ctx.type() != null) {
            type = ctx.type().getText();
        }
        String id = ctx.ID().getText();
        Initialization init = null;
        if (ctx.initialization() != null) {
            init = (Initialization) visit(ctx.initialization());
        }

        int line = ctx.ID().getSymbol().getLine();
        SymbolTableInstance currentElement = new SymbolTableInstance(id, currentNode.objectHash, "Final Variable", line);

        Pair<Boolean, Integer> errorCheck = SymbolTable.semanticErrorsCheck(currentElement);
        if (errorCheck.a) {
            semanticErrors.add("Error: final variable " + id + " at line " + line + " is already defined at line " + errorCheck.b);
        } else {
            SymbolTable.addNode(currentElement);
        }

        return new FinalDeclaration(late, type, id, init);
    }

    @Override
    public Node visitConstDeclarartion(DartGrammarsParser.ConstDeclarartionContext ctx) {
        String type = null;
        if (ctx.type() != null) {
            type = ctx.type().getText();
        }
        String id = ctx.ID().getText();
        Initialization init = (Initialization) visit(ctx.initialization());

        int line = ctx.ID().getSymbol().getLine();
        SymbolTableInstance currentElement = new SymbolTableInstance(id, currentNode.objectHash, "Const Variable", line);
        Pair<Boolean, Integer> errorCheck = SymbolTable.semanticErrorsCheck(currentElement);
        if (errorCheck.a) {
            semanticErrors.add("Error: const variable " + id + " at line " + line + " is already defined at line " + errorCheck.b);
        } else {
            SymbolTable.addNode(currentElement);
        }
        return new ConstDeclaration(type, id, init);
    }

    @Override
    public Node visitNormalDeclarartion(DartGrammarsParser.NormalDeclarartionContext ctx) {
        boolean late = (ctx.LATE() != null);
        String type = null;
        if (ctx.varOrType() != null) {
            type = ctx.varOrType().getText();
        }
        String id = ctx.ID().getText();
        Initialization init = null;
        if (ctx.initialization() != null) {
            init = (Initialization) visit(ctx.initialization());
        }
        int line = ctx.ID().getSymbol().getLine();
        SymbolTableInstance currentElement = new SymbolTableInstance(id, currentNode.objectHash, "Variable", line);
        Pair<Boolean, Integer> errorCheck = SymbolTable.semanticErrorsCheck(currentElement);
        if (errorCheck.a) {
            semanticErrors.add("Error: variable " + id + " at line " + line + " is already defined at line " + errorCheck.b);
        } else {
            SymbolTable.addNode(currentElement);
        }
        return new NormalDeclaration(late, type, id, init);
    }

    @Override
    public Node visitInitialization(DartGrammarsParser.InitializationContext ctx) {
        int line = ctx.start.getLine();
        if (ctx.getChild(1) == ctx.ID()) {
            Variable variable = new Variable(ctx.ID().getText());
            //checking if the variable is defined
            SymbolTableInstance symbolTableInstance = new SymbolTableInstance(variable.id, currentNode.objectHash, "", line);
            Pair<Boolean, Integer> errorCheck = SymbolTable.semanticErrorsCheck(symbolTableInstance);
            if (!errorCheck.a) {
                semanticErrors.add("Error: variable " + variable.id + " at line " + line + " is not defined");
            }
            return new Initialization(variable);
        } else if (ctx.getChild(1) == ctx.CHARACTERS()) {
            Characters chars = new Characters(ctx.CHARACTERS().getText());
            return new Initialization(chars);
        } else {
            Node node = visit(ctx.getChild(1));
            return new Initialization(node);
        }
    }

    @Override
    public Node visitAssign(DartGrammarsParser.AssignContext ctx) {
        String id = ctx.getChild(0).getText();
        int line = ctx.start.getLine();

        //checking if the left-hand variable is defined
        SymbolTableInstance currentElement = new SymbolTableInstance(id, currentNode.objectHash, "", 0);
        Pair<Boolean, Integer> errorCheck = SymbolTable.semanticErrorsCheck(currentElement);
        if (!errorCheck.a) {
            semanticErrors.add("Error: variable " + id + " at line " + line + " is not defined");
        }

        if (ctx.getChild(2) == ctx.ID(1)) {
            Variable variable = new Variable(ctx.getChild(2).getText());
            //checking if the right-hand variable is defined
            SymbolTableInstance symbolTableInstance = new SymbolTableInstance(variable.id, currentNode.objectHash, "", line);
            Pair<Boolean, Integer> errorCheck2 = SymbolTable.semanticErrorsCheck(symbolTableInstance);
            if (!errorCheck2.a) {
                semanticErrors.add("Error: variable " + variable.id + " at line " + line + " is not defined");
            }
            return new Assignment(id, variable);
        } else if (ctx.getChild(2) == ctx.CHARACTERS()) {
            Characters chars = new Characters(ctx.getChild(2).getText());
            return new Assignment(id, chars);
        } else {
            Node node = visit(ctx.getChild(2));
            return new Assignment(id, node);
        }
    }

    @Override
    public Node visitObjectAssign(DartGrammarsParser.ObjectAssignContext ctx) {
        int line = ctx.start.getLine();
        String objectId = ctx.getChild(0).getText();
        //checking if the object is defined
        SymbolTableInstance symbolTableInstance1 = new SymbolTableInstance(objectId, currentNode.objectHash, "", line);
        Pair<Boolean, Integer> errorCheck1 = SymbolTable.semanticErrorsCheck(symbolTableInstance1);
        if (!errorCheck1.a) {
            semanticErrors.add("Error: variable " + objectId + " at line " + line + " is not defined");
        }
        String id = ctx.getChild(2).getText();

        if (ctx.getChild(4) == ctx.ID(2)) {
            Variable variable = new Variable(ctx.getChild(4).getText());
            //checking if the variable is defined
            SymbolTableInstance symbolTableInstance2 = new SymbolTableInstance(variable.id, currentNode.objectHash, "", line);
            Pair<Boolean, Integer> errorCheck2 = SymbolTable.semanticErrorsCheck(symbolTableInstance2);
            if (!errorCheck2.a) {
                semanticErrors.add("Error: variable " + variable.id + " at line " + line + " is not defined");
            }
            return new ObjectAssignment(objectId, id, variable);
        } else if (ctx.getChild(4) == ctx.CHARACTERS()) {
            Characters chars = new Characters(ctx.getChild(4).getText());
            return new ObjectAssignment(objectId, id, chars);
        } else {
            Node node = visit(ctx.getChild(4));
            return new ObjectAssignment(objectId, id, node);
        }
    }

    @Override
    public Node visitThisAssign(DartGrammarsParser.ThisAssignContext ctx) {
        String id = ctx.getChild(2).getText();
        int line = ctx.start.getLine();
        //checking if the class attribute is defined
        SymbolTableInstance symbolTableInstance1 = new SymbolTableInstance(id, parentNode.objectHash, "", line);
        Pair<Boolean, Integer> errorCheck1 = SymbolTable.semanticErrorsCheck(symbolTableInstance1);
        if (!errorCheck1.a) {
            semanticErrors.add("Error: variable " + id + " at line " + line + " is not defined");
        }
        if (ctx.getChild(4) == ctx.ID(1)) {
            Variable variable = new Variable(ctx.getChild(4).getText());
            //checking if the variable is defined
            SymbolTableInstance symbolTableInstance2 = new SymbolTableInstance(variable.id, currentNode.objectHash, "Variable", line);
            Pair<Boolean, Integer> errorCheck2 = SymbolTable.semanticErrorsCheck(symbolTableInstance2);
            if (!errorCheck2.a) {
                semanticErrors.add("Error: variable " + variable.id + " at line " + line + " is not defined");
            }
            return new ThisStatement(id, variable);
        } else if (ctx.getChild(4) == ctx.CHARACTERS()) {
            Characters chars = new Characters(ctx.getChild(4).getText());
            return new ThisStatement(id, chars);
        } else {
            Node node = visit(ctx.getChild(4));
            return new ThisStatement(id, node);
        }
    }

    @Override
    public Node visitList(DartGrammarsParser.ListContext ctx) {
        DartList list = new DartList();
        int idCounter = 0;
        int charsCounter = 0;
        for (int i = 1; i < ctx.getChildCount() - 1; i += 2) {
            if (ctx.getChild(i) == ctx.ID(idCounter)) {
                Variable variable = new Variable(ctx.getChild(i).getText());
                list.addElement(variable);
                idCounter++;
            } else if (ctx.getChild(i) == ctx.CHARACTERS(charsCounter)) {
                Characters chars = new Characters(ctx.getChild(i).getText());
                list.addElement(chars);
                charsCounter++;
            } else {
                list.addElement(visit(ctx.getChild(i)));
            }
        }
        return list;
    }

    @Override
    public Node visitSignature(DartGrammarsParser.SignatureContext ctx) {
        String type = null;
        if (ctx.voidOrType() != null) {
            type = ctx.voidOrType().getText();
        }
        String id = ctx.ID().getText();
        Arguments arguments = (Arguments) visit(ctx.arguments());
        return new Signature(type, id, arguments);
    }

    @Override
    public Node visitFunction(DartGrammarsParser.FunctionContext ctx) {
        Signature signature = (Signature) visit(ctx.getChild(0));
        int line = ctx.signature().ID().getSymbol().getLine();
        String id = signature.id;
        Function func = new Function(signature, null, null);
        func.isAsync = (ctx.ASYNC() != null);

        currentNode = func;
        currentNode.objectHash = func.hashCode();
        //might not need it since current node is not being written to in statements
        parentNode = currentNode;
        SymbolTableInstance currentElement = new SymbolTableInstance(id, 0, "Function", line);
        Pair<Boolean, Integer> errorCheck = SymbolTable.semanticErrorsCheck(currentElement);
        if (errorCheck.a) {
            semanticErrors.add("Error: function " + id + " at line " + line + " is already defined at line " + errorCheck.b);
        } else {
            SymbolTable.addNode(currentElement);
        }
        func.functionBody = (FunctionBody) visit(ctx.functionBody());
        return func;
    }

    @Override
    public Node visitUnnamedFunction(DartGrammarsParser.UnnamedFunctionContext ctx) {
        Arguments arguments = (Arguments) visit(ctx.getChild(1));
        if (ctx.ASYNC() != null) {
            FunctionBody functionBody = (FunctionBody) visit(ctx.getChild(4));
            return new UnnamedFunction(arguments, true, functionBody);
        } else {
            FunctionBody functionBody = (FunctionBody) visit(ctx.getChild(3));
            return new UnnamedFunction(arguments, false, functionBody);
        }
    }

    @Override
    public Node visitArguments(DartGrammarsParser.ArgumentsContext ctx) {
        return visit(ctx.getChild(0));
    }

    @Override
    public Node visitPositionalNamedArguments(DartGrammarsParser.PositionalNamedArgumentsContext ctx) {
        PositionalArguments posArgs = (PositionalArguments) visit(ctx.getChild(0));
        NamedArguments namedArgs = (NamedArguments) visit(ctx.getChild(2));
        return new PositionalNamedArguments(posArgs, namedArgs);
    }

    @Override
    public Node visitPositionalArguments(DartGrammarsParser.PositionalArgumentsContext ctx) {
        List<Argument> args = new ArrayList<>();
        int i = 0;
        while (i < ctx.getChildCount()) {
            Argument argument = (Argument) visit(ctx.getChild(i));
            args.add(argument);
            i += 2;
        }
        return new PositionalArguments(args);
    }

    @Override
    public Node visitNamedArguments(DartGrammarsParser.NamedArgumentsContext ctx) {
        List<NamedArgument> args = new ArrayList<>();
        int requiredCounter = 0;
        int i = 1;
        while (i < ctx.getChildCount() - 1) {
            Argument argument;
            if (ctx.getChild(i) == ctx.REQUIRED(requiredCounter)) {
                requiredCounter++;
                argument = (Argument) visit(ctx.getChild(i + 1));
                args.add(new NamedArgument(argument.type, argument.id, true));
                i += 3;
            } else {
                argument = (Argument) visit(ctx.getChild(i));
                args.add(new NamedArgument(argument.type, argument.id, false));
                i += 2;
            }
        }
        return new NamedArguments(args);
    }

    @Override
    public Node visitZeroArguments(DartGrammarsParser.ZeroArgumentsContext ctx) {
        return new ZeroArguments();
    }

    @Override
    public Node visitArg(DartGrammarsParser.ArgContext ctx) {
        String type = null;
        if (ctx.type() != null) {
            type = ctx.type().getText();
        }
        String id = ctx.ID().getText();
        return new Argument(type, id);
    }

    @Override
    public Node visitFunctionBody(DartGrammarsParser.FunctionBodyContext ctx) {
        List<Statement> statements = new ArrayList<>();
        ReturnStatement returnStatement = null;
        for (int i = 1; i < ctx.getChildCount() - 1; i++) {
            if (ctx.getChild(i) == ctx.returnStatement()) {
                returnStatement = (ReturnStatement) visit(ctx.getChild(i));
            } else {
                statements.add((Statement) visit(ctx.getChild(i)));
                //might not need it since current node is not being written to in statements
                currentNode = parentNode;
            }
        }
        return new FunctionBody(statements, returnStatement);
    }

    @Override
    public Node visitReturnStatement(DartGrammarsParser.ReturnStatementContext ctx) {
        if (ctx.getChildCount() > 2) {
            if (ctx.getChild(1) == ctx.ID()) {
                Variable value = new Variable(ctx.ID().getText());
                int line = ctx.ID().getSymbol().getLine();
                SymbolTableInstance symbolTableInstance = new SymbolTableInstance(value.id, currentNode.objectHash, "", line);
                Pair<Boolean, Integer> errorCheck = SymbolTable.semanticErrorsCheck(symbolTableInstance);
                if (!errorCheck.a) {
                    semanticErrors.add("Error: variable " + value.id + " at line " + line + " is not defined");
                }
                return new ReturnStatement(value);
            } else if (ctx.getChild(1) == ctx.CHARACTERS()) {
                Characters value = new Characters(ctx.getChild(1).getText());
                return new ReturnStatement(value);
            } else {
                Node value = visit(ctx.getChild(1));
                return new ReturnStatement(value);
            }
        } else {
            return new ReturnStatement(null);
        }
    }

    @Override
    public Node visitClass(DartGrammarsParser.ClassContext ctx) {
        boolean Abstract = (ctx.ABSTRACT() != null);
        String id = ctx.ID(0).getText();
        int line = ctx.ID(0).getSymbol().getLine();
        String superClass = null;
        int idCounter = 1;
        if (ctx.EXTENDS() != null) {
            superClass = ctx.ID(idCounter).getText();
            //checking if the super class is defined
            boolean superClassExist = false;
            for (SymbolTableInstance node : SymbolTable.symbolTable) {
                String nodeId = node.id;
                String nodeType = node.category;
                boolean cond1 = (nodeId.compareTo(superClass) == 0);
                boolean cond2 = (nodeType.compareTo("Class") == 0);
                if (cond1 && cond2) {
                    superClassExist = true;
                    break;
                }
            }
            if (!superClassExist) {
                semanticErrors.add("Error: class " + superClass +  " at line " + line + " is not defined");
            }
            idCounter++;
        }

        String impInterface = null;
        if (ctx.IMPLEMENTS() != null) {
            impInterface = ctx.ID(idCounter).getText();
        }

        DartClass dClass = new DartClass(Abstract, id, superClass, impInterface, null);

        currentNode = dClass;
        currentNode.objectHash = dClass.hashCode();
        parentNode = currentNode;

        dClass.classBody = (ClassBody) visit(ctx.classBody());

        SymbolTableInstance currentElement = new SymbolTableInstance(id, 0, "Class", line);
        Pair<Boolean, Integer> errorCheck = SymbolTable.semanticErrorsCheck(currentElement);
        if (errorCheck.a) {
            semanticErrors.add("Error: class " + id + " at line " + line + " is already defined at line" + errorCheck.b);
        } else {
            SymbolTable.addNode(currentElement);
        }
        return dClass;
    }

    @Override
    public Node visitClassBody(DartGrammarsParser.ClassBodyContext ctx) {

        List<ClassAttribute> classAttribute = new ArrayList<>();
        for (int i = 0; i < ctx.attribute().size(); i++) {
            ClassAttribute attribute = (ClassAttribute) visit(ctx.attribute(i));
            //currentNode is never written to via class attributes
            //currentNode = ParentNode;
            classAttribute.add(attribute);
        }

        List<ClassMethod> classMethods = new ArrayList<>();
        for (int i = 0; i < ctx.method().size(); i++) {
            ClassMethod method = (ClassMethod) visit(ctx.method(i));
            currentNode = parentNode;
            classMethods.add(method);
        }


        DefaultConstructor defConst = null;
        if (ctx.defaultConstructer() != null) {
            defConst = (DefaultConstructor) visit(ctx.defaultConstructer());
        }

        return new ClassBody(classAttribute, classMethods, defConst);
    }

    @Override
    public Node visitAttribute(DartGrammarsParser.AttributeContext ctx) {
        boolean isStatic = (ctx.STATIC() != null);
        Declaration dec = (Declaration) visit(ctx.declaration());
        int line = ctx.declaration().start.getLine();
        SymbolTableInstance oldValue = new SymbolTableInstance(dec.id, currentNode.objectHash, "Variable", line);
        SymbolTableInstance newValue = new SymbolTableInstance(dec.id, currentNode.objectHash, "Class Att", line);
        SymbolTable.replaceNode(oldValue, newValue);
        return new ClassAttribute(isStatic, dec);
    }

    @Override
    public Node visitNormalClassMethod(DartGrammarsParser.NormalClassMethodContext ctx) {
        boolean override = (ctx.OVERRIDE() != null);
        Signature signature = (Signature) visit(ctx.signature());
        String id = signature.id;
        boolean async = (ctx.ASYNC() != null);

        NormalClassMethod func = new NormalClassMethod(override, signature, async, null);

        //might remove it bc parentHash will always equal parentNode.objectHash
        int parentHash;
        if (parentNode != null) {
            parentHash = parentNode.objectHash;
        } else {
            parentHash = 0;
        }
        //end of removal
        currentNode = func;
        currentNode.objectHash = func.hashCode();

        func.methodBody = (FunctionBody) visit(ctx.functionBody());

        int line = ctx.signature().ID().getSymbol().getLine();

        SymbolTableInstance currentElement = new SymbolTableInstance(id, parentHash, "Class Method", line);
        Pair<Boolean, Integer> errorCheck = SymbolTable.semanticErrorsCheck(currentElement);

        if (errorCheck.a) {
            semanticErrors.add("Error: class method " + id + " at line " + line + " is already defined at line " + errorCheck.b);
        } else {
            SymbolTable.addNode(currentElement);
        }

        return func;
    }

    @Override
    public Node visitStaticClassMethod(DartGrammarsParser.StaticClassMethodContext ctx) {
        Signature signature = (Signature) visit(ctx.signature());
        boolean async = (ctx.ASYNC() != null);

        StaticClassMethod func = new StaticClassMethod(signature, async, null);

        //might remove it bc parentHash will always equal parentNode.objectHash
        int parentHash;
        if (parentNode != null) {
            parentHash = parentNode.objectHash;
        } else {
            parentHash = 0;
        }
        //end of removal
        currentNode = func;
        currentNode.objectHash = func.hashCode();

        func.methodBody = (FunctionBody) visit(ctx.functionBody());
        int line = ctx.signature().ID().getSymbol().getLine();
        String id = signature.id;

        SymbolTableInstance currentElement = new SymbolTableInstance(id, parentHash, "Static Class Method", line);
        Pair<Boolean, Integer> errorCheck = SymbolTable.semanticErrorsCheck(currentElement);
        if (errorCheck.a) {
            semanticErrors.add("Error: class method " + id + " at line " + line + " is already defined at line " + errorCheck.b);
        } else {
            SymbolTable.addNode(currentElement);
        }
        return func;
    }

    @Override
    public Node visitAbstractClassMethod(DartGrammarsParser.AbstractClassMethodContext ctx) {
        Signature signature = (Signature) visit(ctx.signature());
        int line = ctx.signature().ID().getSymbol().getLine();
        String id = signature.id;

        //might remove it bc parentHash will always equal parentNode.objectHash
        int parentHash;
        if (parentNode != null) {
            parentHash = parentNode.objectHash;
        } else {
            parentHash = 0;
        }
        //end of removal
        SymbolTableInstance currentElement = new SymbolTableInstance(id, parentHash, "Abstract Function", line);
        Pair<Boolean, Integer> errorCheck = SymbolTable.semanticErrorsCheck(currentElement);
        if (errorCheck.a) {
            semanticErrors.add("Error: class method " + id + " at line " + line + " is already defined at line " + errorCheck.b);
        } else {
            SymbolTable.addNode(currentElement);
        }
        return new AbstractClassMethod(signature);
    }

    @Override
    public Node visitNamedConstructor(DartGrammarsParser.NamedConstructorContext ctx) {
        String classId = ctx.ID(0).getText();
        String id = ctx.ID(1).getText();
        ConsArgs consArgs = (ConsArgs) visit(ctx.consArguments());
        FunctionBody functionBody = null;
        if (ctx.functionBody() != null) {
            functionBody = (FunctionBody) visit(ctx.functionBody());
        }
        int line = ctx.ID(1).getSymbol().getLine();

        NamedConstructor namedConstructor = new NamedConstructor(classId, id, consArgs, functionBody);

        //might remove it bc parentHash will always equal parentNode.objectHash
        int parentHash;
        if (parentNode != null) {
            parentHash = parentNode.objectHash;
        } else {
            parentHash = 0;
        }
        //end of removal
        currentNode = namedConstructor;
        currentNode.objectHash = namedConstructor.hashCode();

        SymbolTableInstance currentElement = new SymbolTableInstance(classId + '.' + id, parentHash, "Named Constructor", line);
        Pair<Boolean, Integer> errorCheck = SymbolTable.semanticErrorsCheck(currentElement);

        if (errorCheck.a) {
            semanticErrors.add("Error: named constructor " + classId + "." + id + " at line " + line + " is already defined at line " + errorCheck.b);
        } else {
            SymbolTable.addNode(currentElement);
        }
        return namedConstructor;
    }

    @Override
    public Node visitDefaultConstructer(DartGrammarsParser.DefaultConstructerContext ctx) {
        String id = ctx.ID().getText();
        ConsArgs consArgs = (ConsArgs) visit(ctx.consArguments());
        FunctionBody functionBody = null;
        if (ctx.functionBody() != null) {
            functionBody = (FunctionBody) visit(ctx.functionBody());
        }
        int line = ctx.ID().getSymbol().getLine();

        int parentHash;
        if (parentNode != null) {
            parentHash = parentNode.objectHash;
        } else {
            parentHash = 0;
        }

        DefaultConstructor defaultConstructor = new DefaultConstructor(id, consArgs, functionBody);

        currentNode = defaultConstructor;
        currentNode.objectHash = defaultConstructor.hashCode();

        SymbolTableInstance currentElement = new SymbolTableInstance(id, parentHash, "Constructor", line);
        Pair<Boolean, Integer> errorCheck = SymbolTable.semanticErrorsCheck(currentElement);

        if (errorCheck.a) {
            semanticErrors.add("Error: constructor " + id + " at line " + line + " is already defined at line " + errorCheck.b);
        } else {
            SymbolTable.addNode(currentElement);
        }
        return defaultConstructor;
    }

    @Override
    public Node visitConsArguments(DartGrammarsParser.ConsArgumentsContext ctx) {
        return visit(ctx.getChild(0));
    }


    @Override
    public Node visitConsPositionalNamedArguments(DartGrammarsParser.ConsPositionalNamedArgumentsContext ctx) {
        ConsPositionalArgs consPositionalNamedArgs = (ConsPositionalArgs) visit(ctx.getChild(0));
        ConsNamedArgs consNamedArgs = (ConsNamedArgs) visit(ctx.getChild(2));
        return new ConsPositionalNamedArgs(consPositionalNamedArgs, consNamedArgs);
    }


    @Override
    public Node visitConsPositionalArguments(DartGrammarsParser.ConsPositionalArgumentsContext ctx) {
        List<ConsArg> list = new ArrayList<>();
        for (int i = 0; i < ctx.consArg().size(); i++) {
            ConsArg arg = (ConsArg) visit(ctx.consArg(i));
            list.add(arg);
        }
        return new ConsPositionalArgs(list);
    }

    @Override
    public Node visitConsNamedArguments(DartGrammarsParser.ConsNamedArgumentsContext ctx) {
        List<ConsNamedArg> args = new ArrayList<>();
        int requiredCounter = 0;
        int i = 1;
        while (i < ctx.getChildCount()) {
            ConsArg arg;
            if (ctx.getChild(i) == ctx.REQUIRED(requiredCounter)) {
                requiredCounter++;
                arg = (ConsArg) visit(ctx.getChild(i + 1));
                args.add(new ConsNamedArg(true, arg.type, arg.id));
                i += 3;
            } else {
                arg = (ConsArg) visit(ctx.getChild(i));
                args.add(new ConsNamedArg(false, arg.type, arg.id));
                i += 2;
            }
        }
        return new ConsNamedArgs(args);
    }

    @Override
    public Node visitConZeroArgs(DartGrammarsParser.ConZeroArgsContext ctx) {
        return new ConZeroArgs();
    }

    @Override
    public Node visitConsArg(DartGrammarsParser.ConsArgContext ctx) {
        String id = ctx.ID().getText();
        if (ctx.getChild(0) != ctx.ID()) {
            String type = ctx.getChild(0).getText();
            return new ConsArg(type, id);
        } else {
            return new ConsArg(null, id);
        }
    }

    @Override
    public Node visitFunctionCall(DartGrammarsParser.FunctionCallContext ctx) {
        boolean await = (ctx.AWAIT() != null);
        Parameters parameters = (Parameters) visitParameters(ctx.parameters());
        int size = ctx.ID().size();
        int line = ctx.start.getLine();
        if (size > 1) {
            String objectId = ctx.ID(0).getText();
            //checking if the object is defined
            SymbolTableInstance symbolTableInstance1 = new SymbolTableInstance(objectId, currentNode.objectHash, "", line);
            Pair<Boolean, Integer> errorCheck1 = SymbolTable.semanticErrorsCheck(symbolTableInstance1);
            if(!errorCheck1.a){
                semanticErrors.add("Error: variable " + objectId + " at line " + line + "is not defined");
            }
            String id = ctx.ID(1).getText();
            return new ObjectFunctionCall(objectId, await, id, parameters);
        } else {
            String id = ctx.ID(0).getText();
            //checking if the function is defined
            SymbolTableInstance symbolTableInstance2 = new SymbolTableInstance(id, 0, "", line);
            Pair<Boolean, Integer> errorCheck2 = SymbolTable.semanticErrorsCheck(symbolTableInstance2);
            if(!errorCheck2.a){
                semanticErrors.add("Error: function " + id + " at line " + line + " is not defined");
            }
            return new FunctionCall(await, id, parameters);
        }
    }

    @Override
    public Node visitObject(DartGrammarsParser.ObjectContext ctx) {
        if (ctx.getChild(0) == ctx.NEW()) {
            String id = ctx.getChild(1).getText();
            int line = ctx.start.getLine();
            //checking if the class is defined
            SymbolTableInstance symbolTableInstance = new SymbolTableInstance(id, 0, "", line);
            Pair<Boolean, Integer> errorCheck = SymbolTable.semanticErrorsCheck(symbolTableInstance);
            if (!errorCheck.a) {
                semanticErrors.add("Error: class " + id + " at line " + line + " is not defined");
            }
            Parameters parameters = (Parameters) visit(ctx.parameters());
            return new DartObject(id, parameters);
        } else {
            return visit(ctx.getChild(0));
        }
    }

    @Override
    public Node visitParameters(DartGrammarsParser.ParametersContext ctx) {
        return visit(ctx.getChild(0));
    }

    @Override
    public Node visitPositionalNamedParameters(DartGrammarsParser.PositionalNamedParametersContext ctx) {
        PositionalParameters positionalParameters = (PositionalParameters) visit(ctx.getChild(0));
        NamedParameters namedParameters = (NamedParameters) visit(ctx.getChild(2));
        return new PositionalNamedParameters(positionalParameters, namedParameters);
    }

    @Override
    public Node visitPositionalParameters(DartGrammarsParser.PositionalParametersContext ctx) {
        List<Parameter> parameters = new ArrayList<>();
        for (int i = 0; i < ctx.parameter().size(); i++) {
            Parameter parameter = (Parameter) visit(ctx.parameter(i));
            parameters.add(parameter);
        }
        return new PositionalParameters(parameters);
    }

    @Override
    public Node visitNamedParameters(DartGrammarsParser.NamedParametersContext ctx) {
        List<NamedParameter> namedParameters = new ArrayList<>();
        int i = 0;
        int idCounter = 0;
        while (i < ctx.getChildCount()) {
            String id = ctx.ID(idCounter).getText();
            idCounter++;
            Parameter parameter = (Parameter) visit(ctx.getChild(i + 2));
            NamedParameter namedParameter = new NamedParameter(id, parameter.value);
            namedParameters.add(namedParameter);
            i += 4;
        }
        return new NamedParameters(namedParameters);
    }

    @Override
    public Node visitZeroParameters(DartGrammarsParser.ZeroParametersContext ctx) {
        return new ZeroParameters();
    }

    @Override
    public Node visitParameter(DartGrammarsParser.ParameterContext ctx) {
        Node value;
        if (ctx.getChild(0) == ctx.ID()) {
            value = new Variable(ctx.ID().getText());
        } else if (ctx.getChild(0) == ctx.CHARACTERS()) {
            value = new Characters(ctx.CHARACTERS().getText());
        } else {
            value = visit(ctx.getChild(0));
        }
        return new Parameter(value);
    }

    @Override
    public Node visitMultiplicationExpression(DartGrammarsParser.MultiplicationExpressionContext ctx) {
        Expression left = (Expression) visit(ctx.getChild(0));
        Expression right = (Expression) visit(ctx.getChild(2));
        return new MultiplicationExpression(left, right);
    }

    @Override
    public Node visitDivisionExpression(DartGrammarsParser.DivisionExpressionContext ctx) {
        Expression left = (Expression) visit(ctx.getChild(0));
        Expression right = (Expression) visit(ctx.getChild(2));
        return new DivisionExpression(left, right);
    }

    @Override
    public Node visitAddtitionExpression(DartGrammarsParser.AddtitionExpressionContext ctx) {
        Expression left = (Expression) visit(ctx.getChild(0));
        Expression right = (Expression) visit(ctx.getChild(2));
        return new AdditionExpression(left, right);
    }

    @Override
    public Node visitSubtractExpression(DartGrammarsParser.SubtractExpressionContext ctx) {
        Expression left = (Expression) visit(ctx.getChild(0));
        Expression right = (Expression) visit(ctx.getChild(2));
        return new SubtractExpression(left, right);
    }

    @Override
    public Node visitNumberExpression(DartGrammarsParser.NumberExpressionContext ctx) {
        return visit(ctx.getChild(0));
    }

    @Override
    public Node visitVariableExpression(DartGrammarsParser.VariableExpressionContext ctx) {
        Variable variable = new Variable(ctx.getChild(0).getText());
        int line = ctx.start.getLine();
        SymbolTableInstance symbolTableInstance = new SymbolTableInstance(variable.id, currentNode.objectHash, "Variable", line);
        Pair<Boolean, Integer> errorCheck = SymbolTable.semanticErrorsCheck(symbolTableInstance);
        if (!errorCheck.a) {
            semanticErrors.add("Error: variable " + variable.id + " at line " + line + " is not defined");
        }
        return variable;
    }

    @Override
    public Node visitComponent(DartGrammarsParser.ComponentContext ctx) {
        return visit(ctx.getChild(0));
    }

    @Override
    public Node visitMaterialApp(DartGrammarsParser.MaterialAppContext ctx) {
        if (ctx.getChildCount() > 4) {
            MaterialAppAtts atts = new MaterialAppAtts();
            for (int i = 3; i < ctx.getChildCount() - 1; i++) {
                MaterialAppAtt att = (MaterialAppAtt) visit(ctx.getChild(i));
                atts.addAtt(att);
            }
            return new MaterialApp(atts);
        } else {
            return new MaterialApp();
        }
    }

    @Override
    public Node visitMaterialAppAtts(DartGrammarsParser.MaterialAppAttsContext ctx) {
        return visit(ctx.getChild(0));
    }

    @Override
    public Node visitMaterialTitle(DartGrammarsParser.MaterialTitleContext ctx) {
        String title = ctx.getChild(2).getText();
        return new MaterialTitle(title);
    }

    @Override
    public Node visitMaterialHome(DartGrammarsParser.MaterialHomeContext ctx) {
        DartObject dartObject = (DartObject) visit(ctx.getChild(2));
        return new MaterialHome(dartObject);
    }

    @Override
    public Node visitScaffold(DartGrammarsParser.ScaffoldContext ctx) {
        if (ctx.getChildCount() > 4) {
            ScaffoldAtts atts = new ScaffoldAtts();
            for (int i = 3; i < ctx.getChildCount() - 1; i++) {
                ScaffoldAtt att = (ScaffoldAtt) visit(ctx.getChild(i));
                atts.addAtt(att);
            }
            return new Scaffold(atts);
        } else {
            return new Scaffold();
        }
    }

    @Override
    public Node visitScaffoldAtts(DartGrammarsParser.ScaffoldAttsContext ctx) {
        return visit(ctx.getChild(0));
    }

    @Override
    public Node visitScaffoldBackground(DartGrammarsParser.ScaffoldBackgroundContext ctx) {
        String color = ctx.getChild(2).getText();
        return new ScaffoldBackground(color);
    }

    @Override
    public Node visitScaffoldBody(DartGrammarsParser.ScaffoldBodyContext ctx) {
        DartObject dartObject = (DartObject) visit(ctx.getChild(2));
        return new ScaffoldBody(dartObject);
    }

    @Override
    public Node visitColumn(DartGrammarsParser.ColumnContext ctx) {
        if (ctx.getChildCount() > 4) {
            Column_rowAtts atts = new Column_rowAtts();
            for (int i = 3; i < ctx.getChildCount() - 1; i++) {
                Column_rowAtt att = (Column_rowAtt) visit(ctx.getChild(i));
                atts.addAtt(att);
            }
            return new Column(atts);
        } else {
            return new Column();
        }
    }

    @Override
    public Node visitRow(DartGrammarsParser.RowContext ctx) {
        if (ctx.getChildCount() > 4) {
            Column_rowAtts atts = new Column_rowAtts();
            for (int i = 3; i < ctx.getChildCount() - 1; i++) {
                Column_rowAtt att = (Column_rowAtt) visit(ctx.getChild(i));
                atts.addAtt(att);
            }
            return new Row(atts);
        } else {
            return new Row();
        }
    }

    @Override
    public Node visitColumn_rowAtts(DartGrammarsParser.Column_rowAttsContext ctx) {
        return visit(ctx.getChild(0));
    }

    @Override
    public Node visitMainAxis(DartGrammarsParser.MainAxisContext ctx) {
        String align = ctx.getChild(2).getText();
        return new MainAxis(align);
    }

    @Override
    public Node visitCrossAxis(DartGrammarsParser.CrossAxisContext ctx) {
        String align = ctx.getChild(2).getText();
        return new CrossAxis(align);
    }

    @Override
    public Node visitChildren(DartGrammarsParser.ChildrenContext ctx) {
        DartList dartList = (DartList) visit(ctx.getChild(2));
        return new Column_row_Children(dartList);
    }

    @Override
    public Node visitStack(DartGrammarsParser.StackContext ctx) {
        if (ctx.getChildCount() > 4) {
            StackAtts atts = new StackAtts();
            for (int i = 3; i < ctx.getChildCount() - 1; i++) {
                StackAtt att = (StackAtt) visit(ctx.getChild(i));
                atts.addAtt(att);
            }
            return new Stack(atts);
        } else {
            return new Stack();
        }
    }

    @Override
    public Node visitStackAtts(DartGrammarsParser.StackAttsContext ctx) {
        return visit(ctx.getChild(0));
    }

    @Override
    public Node visitStackFit(DartGrammarsParser.StackFitContext ctx) {
        String fit = ctx.getChild(2).getText();
        return new StackFit(fit);
    }

    @Override
    public Node visitStackChildren(DartGrammarsParser.StackChildrenContext ctx) {
        DartList dartList = (DartList) visit(ctx.getChild(2));
        return new StackChildren(dartList);
    }

    // error
    @Override
    public Node visitText(DartGrammarsParser.TextContext ctx) {
        String text = ctx.getChild(3).getText();
        if (ctx.getChildCount() > 5) {
            TextAtts atts = new TextAtts();
            for (int i = 5; i < ctx.getChildCount() - 1; i++) {
                TextAtt att = (TextAtt) visit(ctx.getChild(i));
                atts.addAtt(att);
            }
            return new Text(text, atts);
        } else {
            return new Text(text);
        }
    }

    @Override
    public Node visitTextAtts(DartGrammarsParser.TextAttsContext ctx) {
        return visit(ctx.getChild(0));
    }

    @Override
    public Node visitTextColor(DartGrammarsParser.TextColorContext ctx) {
        String color = ctx.getChild(2).getText();
        return new TextAtts_Color(color);
    }

    @Override
    public Node visitTextSize(DartGrammarsParser.TextSizeContext ctx) {
        String num = ctx.getChild(2).getText();
        DartInteger size = new DartInteger(Integer.parseInt(num));
        return new TextSize(size);
    }

    @Override
    public Node visitTextStyle(DartGrammarsParser.TextStyleContext ctx) {
        String style = ctx.getChild(2).getText();
        return new TextStyle(style);
    }

    @Override
    public Node visitContainer(DartGrammarsParser.ContainerContext ctx) {
        if (ctx.getChildCount() > 4) {
            ContainerAtts atts = new ContainerAtts();
            for (int i = 3; i < ctx.getChildCount() - 1; i++) {
                ContainerAtt att = (ContainerAtt) visit(ctx.getChild(i));
                atts.addAtt(att);
            }
            return new Container(atts);
        } else {
            return new Container();
        }
    }

    @Override
    public Node visitContainerAtts(DartGrammarsParser.ContainerAttsContext ctx) {
        return visit(ctx.getChild(0));
    }

    @Override
    public Node visitContainerWidth(DartGrammarsParser.ContainerWidthContext ctx) {
        String num = ctx.getChild(2).getText();
        DartInteger width = new DartInteger(Integer.parseInt(num));
        return new ContainerAttsWidth(width);
    }

    @Override
    public Node visitContainerHeight(DartGrammarsParser.ContainerHeightContext ctx) {
        String num = ctx.getChild(2).getText();
        DartInteger height = new DartInteger(Integer.parseInt(num));
        return new ContainerAttsHeight(height);
    }

    @Override
    public Node visitContainerChild(DartGrammarsParser.ContainerChildContext ctx) {
        DartObject dartObject = (DartObject) visit(ctx.getChild(2));
        return new ContainerAttsChild(dartObject);
    }

    @Override
    public Node visitContainerColor(DartGrammarsParser.ContainerColorContext ctx) {
        String color = ctx.getChild(2).getText();
        return new ContainerAttsColor(color);
    }

    @Override
    public Node visitSizedBox(DartGrammarsParser.SizedBoxContext ctx) {
        if (ctx.getChildCount() > 4) {
            SizedBoxAtts atts = new SizedBoxAtts();
            for (int i = 3; i < ctx.getChildCount() - 1; i++) {
                SizedBoxAtt att = (SizedBoxAtt) visit(ctx.getChild(i));
                atts.addAtt(att);
            }
            return new SizedBox(atts);
        } else {
            return new SizedBox();
        }
    }

    @Override
    public Node visitSizedBoxAtts(DartGrammarsParser.SizedBoxAttsContext ctx) {
        return visit(ctx.getChild(0));
    }

    @Override
    public Node visitSizedBoxWidth(DartGrammarsParser.SizedBoxWidthContext ctx) {
        String num = ctx.getChild(2).getText();
        DartInteger width = new DartInteger(Integer.parseInt(num));
        return new SizedBoxWidth(width);
    }

    @Override
    public Node visitSizedBoxHeight(DartGrammarsParser.SizedBoxHeightContext ctx) {
        String num = ctx.getChild(2).getText();
        DartInteger height = new DartInteger(Integer.parseInt(num));
        return new SizedBoxHeight(height);
    }

    @Override
    public Node visitSizedBoxChild(DartGrammarsParser.SizedBoxChildContext ctx) {
        DartObject dartObject = (DartObject) visit(ctx.getChild(2));
        return new SizedBoxChild(dartObject);
    }

    @Override
    public Node visitPadding(DartGrammarsParser.PaddingContext ctx) {
        if (ctx.getChildCount() > 4) {
            PaddingAtts atts = new PaddingAtts();
            for (int i = 3; i < ctx.getChildCount() - 1; i++) {
                PaddingAtt att = (PaddingAtt) visit(ctx.getChild(i));
                atts.addAtt(att);
            }
            return new Padding(atts);
        } else {
            return new Padding();
        }
    }

    @Override
    public Node visitPaddingAtts(DartGrammarsParser.PaddingAttsContext ctx) {
        return visit(ctx.getChild(0));
    }

    @Override
    public Node visitPaddingChild(DartGrammarsParser.PaddingChildContext ctx) {
        DartObject dartObject = (DartObject) visit(ctx.getChild(2));
        return new PaddingChild(dartObject);
    }

    @Override
    public Node visitValues(DartGrammarsParser.ValuesContext ctx) {
        String values = ctx.getChild(2).getText();
        switch (values) {
            case "Values.zero":
                return new Zero();
            case "Values.all":
                String numText = ctx.getChild(4).getText();
                DartInteger num = new DartInteger(Integer.parseInt(numText));
                return new All(num);
            case "Values.symmetric":
                List<HorizontalOrVertical> hORv = new ArrayList<>();
                for (int i = 4; i < ctx.getChildCount() - 1; i++) {
                    if (ctx.getChild(i).getText().equals(")")) {
                        break;
                    }
                    HorizontalOrVertical temp = (HorizontalOrVertical) visit(ctx.getChild(i));
                    hORv.add(temp);
                }
                return new Symmetric(hORv);
            case "Values.costume":
                List<CostumeValues> valuesList = new ArrayList<>();
                for (int i = 4; i < ctx.getChildCount() - 1; i++) {
                    if (ctx.getChild(i).getText().equals(")")) {
                        break;
                    }
                    CostumeValues temp = (CostumeValues) visit(ctx.getChild(i));
                    valuesList.add(temp);
                }
                return new Costume(valuesList);
            default:
                return new All(new DartInteger(0));
        }
    }

    @Override
    public Node visitHorizontalOrVertical(DartGrammarsParser.HorizontalOrVerticalContext ctx) {
        DartInteger number = new DartInteger(Integer.parseInt(ctx.getChild(2).getText()));
        if (ctx.getChild(0) == ctx.HORIZONTAL()) {
            return new Horizontal(number);
        } else {
            return new Vertical(number);
        }
    }

    @Override
    public Node visitCostumeValues(DartGrammarsParser.CostumeValuesContext ctx) {
        DartInteger number = new DartInteger(Integer.parseInt(ctx.getChild(2).getText()));
        if (ctx.getChild(0) == ctx.LEFT()) {
            return new Left(number);
        } else if (ctx.getChild(0) == ctx.TOP()) {
            return new Top(number);
        } else if (ctx.getChild(0) == ctx.RIGHT()) {
            return new Right(number);
        } else {
            return new Bottom(number);
        }
    }

    @Override
    public Node visitInkWell(DartGrammarsParser.InkWellContext ctx) {
        if (ctx.getChildCount() > 4) {
            InkwellAtts atts = new InkwellAtts();
            for (int i = 3; i < ctx.getChildCount() - 1; i++) {
                InkWellAtt att = (InkWellAtt) visit(ctx.getChild(i));
                atts.addAtt(att);
            }
            return new InkWell(atts);
        } else {
            return new InkWell();
        }
    }

    @Override
    public Node visitInkWellAtts(DartGrammarsParser.InkWellAttsContext ctx) {
        return visit(ctx.getChild(0));
    }

    @Override
    public Node visitInkWellChild(DartGrammarsParser.InkWellChildContext ctx) {
        DartObject dartObject = (DartObject) visit(ctx.getChild(2));
        return new InkWellChild(dartObject);
    }

    @Override
    public Node visitInkWellOnTap(DartGrammarsParser.InkWellOnTapContext ctx) {
        if (ctx.getChild(2) == ctx.functionCall()) {
            FunctionCall functionCall = (FunctionCall) visit(ctx.getChild(2));
            return new Inkwell_OnTap_FunctionCall(functionCall);
        } else {
            UnnamedFunction unnamedFunction = (UnnamedFunction) visit(ctx.getChild(2));
            return new Inkwell_OnTap_UnnamedFunction(unnamedFunction);
        }
    }

    @Override
    public Node visitImage(DartGrammarsParser.ImageContext ctx) {
        String src = ctx.getChild(3).getText();
        if (ctx.getChildCount() > 6) {
            ImageAtts atts = new ImageAtts();
            for (int i = 5; i < ctx.getChildCount() - 1; i++) {
                ImageAtt att = (ImageAtt) visit(ctx.getChild(i));
                atts.addAtt(att);
            }
            return new Image(src, atts);
        } else {
            return new Image(src);
        }
    }

    @Override
    public Node visitImageAtts(DartGrammarsParser.ImageAttsContext ctx) {
        return visit(ctx.getChild(0));
    }

    @Override
    public Node visitImageFit(DartGrammarsParser.ImageFitContext ctx) {
        String fit = ctx.getChild(2).getText();
        return new ImageFit(fit);
    }

    @Override
    public Node visitImageWidth(DartGrammarsParser.ImageWidthContext ctx) {
        DartInteger width = new DartInteger(Integer.parseInt(ctx.getChild(2).getText()));
        return new ImageAttsWidth(width);
    }

    @Override
    public Node visitImageHeight(DartGrammarsParser.ImageHeightContext ctx) {
        DartInteger height = new DartInteger(Integer.parseInt(ctx.getChild(2).getText()));
        return new ImageAttsHeight(height);
    }

    @Override
    public Node visitButton(DartGrammarsParser.ButtonContext ctx) {
        if (ctx.getChildCount() > 4) {
            ButtonAtts atts = new ButtonAtts();
            for (int i = 3; i < ctx.getChildCount() - 1; i++) {
                ButtonAtt att = (ButtonAtt) visit(ctx.getChild(i));
                atts.addAtt(att);
            }
            return new Button(atts);
        } else {
            return new Button();
        }
    }

    @Override
    public Node visitButtonAtts(DartGrammarsParser.ButtonAttsContext ctx) {
        return visit(ctx.getChild(0));
    }

    @Override
    public Node visitButtonOnTap(DartGrammarsParser.ButtonOnTapContext ctx) {
        if (ctx.getChild(2) == ctx.functionCall()) {
            FunctionCall functionCall = (FunctionCall) visit(ctx.getChild(2));
            return new Button_OnTap_functionCall(functionCall);
        } else {
            UnnamedFunction unnamedFunction = (UnnamedFunction) visit(ctx.getChild(2));
            return new Button_OnTap_unnamedFunction(unnamedFunction);
        }
    }

    @Override
    public Node visitButtonChild(DartGrammarsParser.ButtonChildContext ctx) {
        DartObject dartObject = (DartObject) visit(ctx.getChild(2));
        return new ButtonChild(dartObject);
    }

    @Override
    public Node visitButtonColor(DartGrammarsParser.ButtonColorContext ctx) {
        String color = ctx.getChild(2).getText();
        return new ButtonColor(color);
    }

    @Override
    public Node visitScrollView(DartGrammarsParser.ScrollViewContext ctx) {
        if (ctx.getChildCount() > 4) {
            ScrollViewAtts atts = new ScrollViewAtts();
            for (int i = 3; i < ctx.getChildCount() - 1; i++) {
                ScrollViewAtt att = (ScrollViewAtt) visit(ctx.getChild(i));
                atts.addAtt(att);
            }
            return new ScrollView(atts);
        } else {
            return new ScrollView();
        }
    }

    @Override
    public Node visitScrollViewAtts(DartGrammarsParser.ScrollViewAttsContext ctx) {
        return visit(ctx.getChild(0));
    }

    @Override
    public Node visitScrollDirection(DartGrammarsParser.ScrollDirectionContext ctx) {
        String dir = ctx.getChild(2).getText();
        return new ScrollViewDirection(dir);
    }

    @Override
    public Node visitScrollChild(DartGrammarsParser.ScrollChildContext ctx) {
        DartObject dartObject = (DartObject) visit(ctx.getChild(2));
        return new ScrollViewChild(dartObject);
    }

    ////////////////////////////////////

    @Override
    public Node visitListItem(DartGrammarsParser.ListItemContext ctx) {
        String listId = ctx.ID().getText();
        int index = Integer.parseInt(ctx.INT_NUM().getText());
        return new ListItem(listId, index);
    }

    @Override
    public Node visitMap(DartGrammarsParser.MapContext ctx) {
        DartMap map = new DartMap();
        int idCounter = 0;
        int charsCounter = 0;
        for (int i = 1; i < ctx.getChildCount() - 1; i += 4) {
            String key = ctx.getChild(i).getText();
            charsCounter++;
            if (ctx.getChild(i + 2) == ctx.ID(idCounter)) {
                Variable variable = new Variable(ctx.getChild(i + 2).getText());
                map.addElement(new Pair<>(key, variable));
                idCounter++;
            } else if (ctx.getChild(i + 2) == ctx.CHARACTERS(charsCounter)) {
                Characters chars = new Characters(ctx.getChild(i + 2).getText());
                map.addElement(new Pair<>(key, chars));
                charsCounter++;
            } else {
                map.addElement(new Pair<>(key, visit(ctx.getChild(i + 2))));
            }
        }
        return map;
    }

    @Override
    public Node visitMapItem(DartGrammarsParser.MapItemContext ctx) {
        String mapId = ctx.ID().getText();
        String key = ctx.CHARACTERS().getText();
        return new MapItem(mapId, key);
    }

    @Override
    public Node visitNavigationPushing(DartGrammarsParser.NavigationPushingContext ctx) {
        Page page = (Page) visit(ctx.page());
        return new NavigationPushing(page);
    }

    @Override
    public Node visitNavigationPopping(DartGrammarsParser.NavigationPoppingContext ctx) {
        return new NavigationPopping();
    }

    @Override
    public Node visitPage(DartGrammarsParser.PageContext ctx) {
        Route route = (Route) visit(ctx.route());
        if (ctx.getChildCount() > 1) {
            Parameter parameter = (Parameter) visit(ctx.parameter());
            return new Page(route, parameter);
        }
        return new Page(route);
    }

    @Override
    public Node visitStringRoute(DartGrammarsParser.StringRouteContext ctx) {
        return new StringRoute(ctx.getText());
    }

    @Override
    public Node visitObjectRoute(DartGrammarsParser.ObjectRouteContext ctx) {
        DartObject object = (DartObject) visit(ctx.object());
        return new ObjectRoute(object);
    }

    @Override
    public Node visitPageArgsExtracting(DartGrammarsParser.PageArgsExtractingContext ctx) {
        String type = ctx.varOrType().getText();
        String id = ctx.ID().getText();
        return new PageArgsExtracting(type, id);
    }

    @Override
    public Node visitSetState(DartGrammarsParser.SetStateContext ctx) {
        Block block = (Block) visit(ctx.block());
        return new SetState(block);
    }
}