package flutter;

public class ContainerAttsColor extends ContainerAtt {
    public String color;

    public ContainerAttsColor(String color){

        this.color= color;
    }
    @Override
    public String toString() {

        return "containerColor: " + color.toString();
    }
}
//    : COLOR':'COLORS COMMA?
