package nodes;

public class ReturnStatement extends Node{
    public Node returnValue;

    public ReturnStatement(Node returnValue){
        if(returnValue != null){
            this.returnValue = returnValue;
        }
    }

    @Override
    public String toString() {
        if(returnValue != null) {
            return "return" + " " + returnValue.toString() + ";";
        }else {
            return "return;" ;
        }
    }

    @Override
    public StringBuilder astImp() {
        return new StringBuilder("return").append("\n\t\t").append(returnValue.astImp());
    }
}
