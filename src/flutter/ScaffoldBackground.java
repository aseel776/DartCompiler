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
      
        String top = "<script"  +  this.setWidgetName("ScaffoldBackground", this.hashCode())   +">";
        this.printLine(top);
        // Get the parent (scaffold) of parent (scaffoldAtts) element"
        top.concat("var parentDiv = document.currentScript.parentNode.parentNode;" );
        this.printLine(top);
        // Add a class to the parent element
        top.concat("parentDiv."+this.setClassNameByJs("bg-"+ color + "')") );
        this.printLine(top);
        top.concat("parentDiv."+this.setClassNameByJs("w-100"));// to get full parent width 
        this.printLine(top);
        top.concat("parentDiv."+this.setClassNameByJs("h-100"));// to get full parent hight 
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
