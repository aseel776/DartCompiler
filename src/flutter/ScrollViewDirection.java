package flutter;

import enums.ScrollDirection;

public abstract class ScrollViewDirection extends ScrollViewAtt {
    public ScrollDirection scrollDirection;
    public ScrollViewDirection(ScrollDirection scrollDirection){
        this.scrollDirection=scrollDirection;
    }

    @Override
    public String toString() {
        return "scrollDirection:" + scrollDirection.toString();
    }
}