package nodes;

public class AbstractClassMethod extends ClassMethod{

    public Signature signature;

    public AbstractClassMethod(Signature signature){
        this.signature = signature;
    }

    @Override
    public String toString() {
        return "abstract" + " " + signature.toString() + ';' ;
    }

    @Override
    public StringBuilder astImp() {
        StringBuilder str = new StringBuilder("abstract class method");
        str.append("\n\t\t").append("abstract");
        str.append("\n\t\t").append(signature.astImp());
        return str;
    }
}
