package flutter;

import nodes.ZeroParameters;

public class Column extends Component{

    public Column_rowAtts columnAtts;

    public Column(Column_rowAtts atts){
        super("Column",atts);
        this.columnAtts=atts;
    }

    public Column(){
        super("Column", new ZeroParameters());
    }

    @Override
    public String toString() {
        if(columnAtts != null){
            return "new Column (\n" + columnAtts.toString()+"\n);";
        }else{
            return "new Column ()";
        }
    }

    @Override
    public StringBuilder astImp() {
        StringBuilder str = new StringBuilder("column");
        if(columnAtts != null){
            str.append("\n\t\t").append(columnAtts.astImp());
        }
        return str;
    }
    @Override
    public String codeGenerationImp() {
        String classes []= {"d-flex", "flex-column"}; 

        String top= Utils.setCommentWidgetName("Column", this.hashCode());

        top.concat( "<div"+ Utils.setClassesNames(classes) +">" );
        Utils.printLine(top);
        top.concat( columnAtts.codeGenerationImp());
        Utils.printLine(top);
        top.concat("</div>");

        return top;
    }
}
