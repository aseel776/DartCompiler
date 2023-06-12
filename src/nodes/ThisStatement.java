package nodes;

public class ThisStatement extends Assignment{

    public ThisStatement(String id, Node value){
        super(id, value);
    }

    @Override
    public String toString() {
        return "this." + id + " = " + value.toString() + ";";
    }
    @Override
    public String codeGenerationImp() {
        String str = "";
        str = "$" + "this" + "->" + id + "=" + "$"+ value.codeGenerationImp() + ";";
        return str;
    }
}
