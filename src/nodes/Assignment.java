package nodes;

public class Assignment extends Statement{
    public String id;
    public Node value;

    public Assignment(String id, Node value){
        this.id = id;
        this.value = value;
    }

    @Override
    public String toString() {
        return id + " = " + value.toString() + ";";
    }

    @Override
    public StringBuilder astImp() {
        StringBuilder str = new StringBuilder("assignment");
        str.append("\n\t\t").append(this);
        return str;
    }
}
