package flutter;

public class Zero extends PaddingValues {

    @Override
    public String toString() {
        return "values: Values.zero";
    }

    @Override
    public StringBuilder astImp() {
        return new StringBuilder("values").append("\n\t\t").append(this);
    }
}