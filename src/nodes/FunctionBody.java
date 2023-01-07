package nodes;

import java.util.List;

public class FunctionBody extends Block {
    public ReturnStatement returnStatement;

    public FunctionBody(List<Statement> statements, ReturnStatement returnStatement){
        this.statements = statements;
        if(returnStatement != null){
            this.returnStatement = returnStatement;
        }
    }

    @Override
    public String toString() {
        String body = "( \n";
        for (Statement statement: statements) {
            body = body.concat(statement.toString() + '\n');
        }
        if(returnStatement != null){
            body = body.concat(returnStatement.toString() + "\n)");
        }else{
            body = body.concat(")");
        }
        return body;
    }
}
