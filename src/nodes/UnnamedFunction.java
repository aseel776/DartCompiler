package nodes;

public class UnnamedFunction extends Node{
    public Arguments arguments;
    public Boolean isAsync;
    public FunctionBody functionBody;

    public UnnamedFunction(Arguments arguments, Boolean isAsync, FunctionBody functionBody){
        this.arguments = arguments;
        this.isAsync = isAsync;
        this.functionBody = functionBody;
    }

    @Override
    public String toString() {
        if(isAsync){
            return arguments.toString() + " " + "async" + functionBody.toString();
        }else {
            return arguments.toString() + " " + functionBody.toString();
        }
    }
}
