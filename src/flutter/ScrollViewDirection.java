package flutter;

public abstract class ScrollViewDirection extends ScrollViewAtt {
    public String scrollDirection;
    public ScrollViewDirection(String scrollDirection){
        this.scrollDirection=scrollDirection;
    }

    @Override
    public String toString() {
        return "scrollDirection:" + scrollDirection;
    }
}