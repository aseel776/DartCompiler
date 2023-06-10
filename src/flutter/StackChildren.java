package flutter;

import nodes.DartList;

public class StackChildren extends StackAtt{

    public DartList list ;

    public StackChildren(DartList list){
        this.list=list;
    }

    @Override
    public String toString() {
        return "stackChildren:"+ list.toString();
    }

    @Override
    public StringBuilder astImp() {
        StringBuilder str = new StringBuilder("stack children");
        str.append("\n\t\t").append(list.astImp());
        return str;
    }
}
