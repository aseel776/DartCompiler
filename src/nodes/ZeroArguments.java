package nodes;

public class ZeroArguments extends Arguments{

    @Override
    public String toString() {
        return "()";
    }

    @Override
    public StringBuilder astImp() {
        return new StringBuilder("zero arguments");
    }
}
