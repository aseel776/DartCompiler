package nodes;

public class Function extends Statement{
    public Signature signature;
    public Boolean isAsync;
    public FunctionBody functionBody;

    public Function(Signature signature, Boolean isAsync, FunctionBody functionBody){
        this.signature = signature;
        this.isAsync = isAsync;
        this.functionBody = functionBody;
    }

    @Override
    public String toString() {
        if(isAsync){
            return signature.toString() + " " + "async" + functionBody.toString();
        }else {
            return signature.toString() + " " + functionBody.toString();
        }
    }

    @Override
    public StringBuilder astImp() {
        StringBuilder str = new StringBuilder("function");
        str.append("\n\t\t").append(signature.astImp());
        if(isAsync){
            str.append("\n\t\tasync");
        }
        str.append("\n\t\t").append(functionBody.astImp());
        return str;
    }
}
