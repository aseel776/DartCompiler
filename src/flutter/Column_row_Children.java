package flutter;

import nodes.ListType;

public  class Column_row_Children extends Column_rowAtts{
    ListType list ;
    public Column_row_Children(ListType list){
        this.list=list;
    }

    @Override
    public String toString() {
        return "children:"+ list.toString();
    }
}
//    : CHILDREN':'list COMMA?

