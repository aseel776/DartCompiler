package flutter;

import nodes.ZeroParameters;

public class MaterialApp extends Component {
    public MaterialAppAtts materialAppAtts;

    public MaterialApp(MaterialAppAtts atts) {
        super("MaterialApp", atts);
        this.materialAppAtts = atts;
    }

    public MaterialApp() {
        super("MaterialApp", new ZeroParameters());
    }

    @Override
    public String toString() {
        if (materialAppAtts != null) {
            return "new MaterialApp (\n" + materialAppAtts.toString() + "\n)";
        } else {
            return "new MaterialApp()";
        }
    }

    @Override
    public StringBuilder astImp() {
        StringBuilder str = new StringBuilder("material app");
        if (materialAppAtts != null) {
            str.append("\n\t\t").append(materialAppAtts.astImp());
        }
        return str;
    }

    // MaterialApp it tells Flutter that you are going to use Material components
    // and follow the material design in your app.
    /**
     * by GPT
     * In Flutter, the MaterialApp widget is the root of the widget tree ,
     * and is responsible for setting up the basic structure and behavior of the
     * application.
     * In HTML, there is no direct equivalent element to MaterialApp.
     * However, you can use the <div> or <body> tag as the closest approximation.
     */
    // i use body because the body must be the root of page
    // class='container' for container for the content

    @Override
    public String codeGenerationImp() {
        String top = Utils.setCommentWidgetName("MaterialApp", this.hashCode());
        top =top.concat( "<body" + Utils.setClassName("container") + ">");
        top =top.concat("\n");
        top =top = top.concat(materialAppAtts.codeGenerationImp());
        top =top.concat("\n");
        top =top.concat("</body>");
        return top;

    }

}