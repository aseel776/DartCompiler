package flutter;

import java.util.ArrayList;
import java.util.List;

public class Row extends Component{


    public List<Column_rowAtts> column_rowAtts ;
    public Row(){
        this.column_rowAtts= new ArrayList<>();
    }
    public Row(List<Column_rowAtts> listt ){
        this.column_rowAtts= listt;
    }
    public void addColumn_rowAtts(Column_rowAtts cm ){
        column_rowAtts.add(cm);
    }
    @Override
    public String toString() {
        String top= new String( "new Row (" )  ;
        for (int i = 0; i < column_rowAtts.size(); i++) {
            if (i == column_rowAtts.size() - 1) {
                top = top.concat(column_rowAtts.toString() + "\n");
            } else {
                top = top.concat(column_rowAtts.toString() + "," + "\n");
            }
        }
        top = top.concat(")");
        return top ;
    }
}
