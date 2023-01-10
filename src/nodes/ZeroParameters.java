package nodes;

public class ZeroParameters extends Parameters{

    @Override
    public String toString() {
        return "()";
    }

    @Override
    public StringBuilder astImp() {
        return new StringBuilder("zero parameters");
    }
}
