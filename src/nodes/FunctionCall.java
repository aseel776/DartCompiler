package nodes;

public class FunctionCall extends Statement{

    public Boolean await;
    public String id;
    public Parameters parameters;

    public FunctionCall(Boolean await, String id, Parameters parameters){
        this.await = await;
        this.id = id;
        this.parameters = parameters;
    }

    @Override
    public String toString() {
        if(await){
            return "await" + " " + id + parameters.toString() + ";" ;
        }else {
            return id + parameters.toString() + ";" ;
        }
    }

    @Override
    public StringBuilder astImp() {
        StringBuilder str = new StringBuilder("function call");
        if(await){
            str.append("\n\t\tawait");
        }
        str.append("\n\t\t").append(id);
        str.append("\n\t\t").append(parameters.astImp());
        return str;
    }
}
