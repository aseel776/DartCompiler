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
}
