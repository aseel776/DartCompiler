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
        String top="<button onclick='goBack()' style='color: #fff; background-color: #333;'>go Back</button>\n";
        top=top.concat("<script> \n");
        top=top.concat(" function goBack(){window.history.back()}\n");
        top=top.concat("</script>\n");
        return top;
    }
}
