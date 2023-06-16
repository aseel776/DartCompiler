package flutter;

import nodes.ZeroParameters;

public class Container extends Component {
    ContainerAtts containerAtts;

    public Container(ContainerAtts containerAtts) {
        super("Container", containerAtts);
        this.containerAtts = containerAtts;
    }

    public Container() {
        super("Container", new ZeroParameters());
    }

    @Override
    public String toString() {
        if (containerAtts != null) {
            return "new Container (\n" + containerAtts.toString() + "\n);";
        } else {
            return "new Container ()";
        }
    }

    @Override
    public StringBuilder astImp() {
        StringBuilder str = new StringBuilder("container");
        if (containerAtts != null) {
            str.append("\n\t\t").append(containerAtts.astImp());
        }
        return str;
    }

    @Override
    public String codeGenerationImp() {

        String top = Utils.setCommentWidgetName("Container", this.hashCode());
        top =top.concat("<div>");
        top =top.concat("\n");
        top =top.concat(containerAtts.codeGenerationImp());
        top =top.concat("\n");
        top =top.concat("</div>");
        return top;

    }
}

/*
<!-- Container 1321 -->
<div>
  <!-- ContainerAtts 2141241-->
  <!-- ContainerAttsWidth 4841665 -->
  <script>
    var parentDiv = document.currentScript.parentNode;
    parentDiv.style.width = "number px";
  </script>
  <!-- ContainerAttsHeight 116785 -->
  <script>
    var parentDiv = document.currentScript.parentNode;
    parentDiv.style.height  = "number px";
  </script>
  <!-- ContainerAttsColor 8498561 -->
  <script>
    var parentDiv = document.currentScript.parentNode;
    parentDiv.classList.add("bg-color");
  </script>
  <!-- ContainerAttsChild 8498734 -->
        Child_Content 

</div>

*/

/* the final result 
<div style="width:Xpx; height :Ypx;" class="bg-colorName">
  
     content in child 
  
</div>
*/