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
}
