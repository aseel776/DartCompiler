package flutter;

public abstract class ScrollDirection extends ScrollViewAtts {
    public enums.ScrollDirection scrollDirection;
    public ScrollDirection(enums.ScrollDirection scrollDirection){
        this.scrollDirection=scrollDirection;
    }

    @Override
    public String toString() {
        return "scrollDirection:" + scrollDirection.toString();
    }
}

//scrollDirection
//        : SCROLL_DIRECTION':' (HORIZONTAL | VERTICAL) COMMA?
//        ;