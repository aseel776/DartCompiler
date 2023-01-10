package flutter;

public class ScrollViewDirection extends ScrollViewAtt {

    public String scrollDirection;

    public ScrollViewDirection(String scrollDirection){
        this.scrollDirection=scrollDirection;
    }

    @Override
    public String toString() {
        return "scrollDirection: " + scrollDirection;
    }

    @Override
    public StringBuilder astImp() {
        StringBuilder str = new StringBuilder("scroll direction");
        str.append("\n\t\t").append(this);
        return str;
    }
}