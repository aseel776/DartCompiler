package flutter;

import nodes.ZeroParameters;

public class Row extends Component{

    public Column_rowAtts rowAtts;

    public Row(Column_rowAtts atts){
        super("Row",atts);
        this.rowAtts=atts;
    }

    public Row(){
        super("Row", new ZeroParameters());
    }

    @Override
    public String toString() {
        if(rowAtts != null){
            return "new Row (\n" + rowAtts.toString()+"\n);";
        }else {
            return "new Row ()";
        }
    }

    @Override
    public StringBuilder astImp() {
        StringBuilder str = new StringBuilder("row");
        if(rowAtts != null){
            str.append("\n\t\t").append(rowAtts.astImp());
        }
        return str;
    }
}
