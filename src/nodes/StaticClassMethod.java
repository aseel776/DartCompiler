package nodes;

public class StaticClassMethod extends ClassMethod{

    public Signature signature;
    public Boolean isAsync;
    public FunctionBody methodBody;

    public StaticClassMethod(Signature signature, Boolean isAsync, FunctionBody methodBody){
        this.signature = signature;
        this.isAsync = isAsync;
        this.methodBody = methodBody;
    }

    @Override
    public String toString() {
        String method = "static" + " " + signature.toString() + " ";
        if(isAsync){
            method = method.concat("async");
        }
        method = method.concat(methodBody.toString());
        return method;
    }

    @Override
    public StringBuilder astImp() {
        StringBuilder str = new StringBuilder("static class method");
        str.append("\n\t\t").append(signature.astImp());
        if(isAsync){
            str.append("\n\t\tasync");
        }
        str.append("\n\t\t").append(methodBody.astImp());
        return str;
    }
}
