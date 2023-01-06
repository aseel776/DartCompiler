package nodes;

public class NamedParameter extends Parameter{
    public String id;

    public NamedParameter(String id, Node value){
        super(value);
        this.id = id;
    }

    @Override
    public String toString() {
        return id + ":" + " " + value.toString();
    }
}
