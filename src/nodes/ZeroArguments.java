package nodes;

public class ZeroArguments extends Arguments{

    @Override
    public String toString() {
        return "()";
    }

    @Override
    public void check(int line){}

    @Override
    public StringBuilder astImp() {
        return new StringBuilder("zero arguments");
    }
}
