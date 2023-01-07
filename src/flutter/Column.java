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
}
