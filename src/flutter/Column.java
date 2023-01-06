package flutter;

import java.util.ArrayList;
import java.util.List;

public class Column extends Component{
    public Column_rowAtts column_rowAtts_;
public Column(Column_rowAtts atts){
    super("Colume",atts);
    this.column_rowAtts_=atts;
}

@Override
    public String toString() {
       return "new Column (\n" + column_rowAtts_.toString()+"\n);";
    }
}
