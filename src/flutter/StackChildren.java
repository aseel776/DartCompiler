package flutter;

import nodes.ListType;

public class StackChildren extends StackAtts{
    ListType list ;
    public StackChildren(ListType list){
        this.list=list;
    }

    @Override
    public String toString() {
        return "children:"+ list.toString();
    }
}
