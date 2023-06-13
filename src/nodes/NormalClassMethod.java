package nodes;

public class NormalClassMethod extends ClassMethod{

    public Boolean overrides;
    public Signature signature;
    public Boolean isAsync;
    public FunctionBody methodBody;

    public NormalClassMethod(Boolean overrides, Signature signature, Boolean isAsync, FunctionBody methodBody){
        this.overrides = overrides;
        this.signature = signature;
        this.isAsync = isAsync;
        this.methodBody = methodBody;
    }

    @Override
    public String toString() {
        String method;
        if(overrides){
            method = "@override" + " " + signature.toString() + " ";
        }else {
            method = signature.toString() + " ";
        }
        if(isAsync){
            method = method.concat("async");
        }
        method = method.concat(methodBody.toString());
        return method;
    }

    @Override
    public StringBuilder astImp() {
        StringBuilder str = new StringBuilder("class method");
        if(overrides){
            str.append("\n\t\toverrides");
        }
        str.append("\n\t\t").append(signature.astImp());
        if(isAsync){
            str.append("\n\t\tasync");
        }
        str.append("\n\t\t").append(methodBody.astImp());
        return str;
    }

    @Override
    public String codeGenerationImp() {
        String str = "function";
        str = str.concat(signature.codeGenerationImp() + " ") ;
        str = str.concat(methodBody.codeGenerationImp());
        return str;

    }
}
