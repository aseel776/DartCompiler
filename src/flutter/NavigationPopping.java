package flutter;

public class NavigationPopping extends Navigation{

    @Override
    public String toString() {
        return "Navigator.pop()";
    }

    @Override
    public StringBuilder astImp() {
        return new StringBuilder("pop");
    }

    @Override
    public String codeGenerationImp() {
        return("<script>window.history.back()</script>\n");
        
    }
}
