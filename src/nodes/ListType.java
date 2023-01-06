package nodes;

import java.util.ArrayList;
import java.util.List;

public class ListType extends Node{
    List<Node> elements;

    public ListType(List<Node> elements){
        this.elements = elements;
    }

    public ListType(){
        elements = new ArrayList<>();
    }

    void addElement(Node element){
        elements.add(element);
    }

    @Override
    public String toString() {
        String list = "[";
        for(int i = 0; i < elements.size(); i++){
            if(i == elements.size() - 1){
                list = list.concat(elements.get(i).toString());
            }else {
                list = list.concat(elements.get(i).toString() + ',');
            }
        }
        list = list.concat("]");
        return list;
    }
}
