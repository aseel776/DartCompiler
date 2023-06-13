package flutter;

public class ScaffoldBackground extends ScaffoldAtt {

    public String color;

    public ScaffoldBackground(String color) {
        super();
        this.color = color;
    }

    @Override
    public String toString() {

        return "backgroundColor:" + color.toString();
    }

    @Override
    public StringBuilder astImp() {
        StringBuilder str = new StringBuilder("scaffold background color");
        str.append("\n\t\t").append(this);
        return str;
    }

    @Override
    public String codeGenerationImp() {
      
        String top = "<script"  +  Utils.setWidgetName("ScaffoldBackground", this.hashCode())   +">";
        Utils.printLine(top);
        // Get the parent (scaffold) of parent (scaffoldAtts) element"
        top.concat("var parentDiv = document.currentScript.parentNode.parentNode;" );
        Utils.printLine(top);
        // Add a class to the parent element
        top.concat("parentDiv."+Utils.setClassNameByJs("bg-"+ color + "')") );
        Utils.printLine(top);
        top.concat("parentDiv."+Utils.setClassNameByJs("w-100"));// to get full parent width 
        Utils.printLine(top);
        top.concat("parentDiv."+Utils.setClassNameByJs("h-100"));// to get full parent hight 
        top.concat("</script>" );
        return top;
    }
    /*
     * <script name='ScaffoldBackground 3718'>
     *      var parentDiv = document.currentScript.parentNode.parentNode;
     *      parentDiv.classList.add('bg-color');
     *      parentDiv.classList.add('h-100');
     *      parentDiv.classList.add('w-100');
     * </script>
     */ 
}
