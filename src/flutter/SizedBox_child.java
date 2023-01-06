package flutter;

public class SizedBox_child extends SizedBoxAtts{
    String object;
    public SizedBox_child(String object){
        this.object=object;
    }

    @Override
    public String toString() {
        return "child:" +object.toString();
    }
}

//child
//        : CHILD':'object COMMA?
//        ;