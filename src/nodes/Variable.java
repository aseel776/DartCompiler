package nodes;

public class Variable extends Expression{

    public String id;

    public Variable(String id){
        this.id = id;
    }

    @Override
    public String toString() {
        return id;
    }

    @Override
    public StringBuilder astImp() {
        return new StringBuilder("variable").append("\n\t\t").append(id);
    }
}
