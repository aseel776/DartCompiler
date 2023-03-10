package flutter;

import nodes.ListType;

public  class Column_row_Children extends Column_rowAtt{

    public ListType list ;
    public Column_row_Children(ListType list){
        this.list=list;
    }

    @Override
    public String toString() {
        return "children:"+ list.toString();
    }

    @Override
    public StringBuilder astImp() {
        StringBuilder str = new StringBuilder("children");
        str.append("\n\t\t").append(list.astImp());
        return str;
    }
}

