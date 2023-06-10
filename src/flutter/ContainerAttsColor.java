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

    @Override
    public StringBuilder astImp() {
        StringBuilder str = new StringBuilder("container color");
        str.append("\n\t\t").append(this);
        return str;
    }
}
