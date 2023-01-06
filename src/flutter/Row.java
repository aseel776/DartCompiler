package flutter;
public class Row extends Component{
    public Column_rowAtts column_rowAtts;
    public Row(Column_rowAtts atts){
        super("Row",atts);
        this.column_rowAtts=atts;
    }
    @Override
    public String toString() {
        return "new Row (\n" + column_rowAtts.toString()+"\n);";
    }

}
