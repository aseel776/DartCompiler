package flutter;

public class ContainerAttsChild extends ContainerAtts{


    public String object;
    public ContainerAttsChild(String object) {
        this.object = object;
    }
    @Override
    public String toString() {
        return  "child:"+ object.toString();

    }
}
//    : CHILD':'object COMMA?
