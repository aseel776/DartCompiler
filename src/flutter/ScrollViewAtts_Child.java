package flutter;

public class ScrollViewAtts_Child extends ScrollViewAtts{
    String object;
    public ScrollViewAtts_Child(String object) {
        this.object = object;
    }
    @Override
    public String toString() {
        return  "child:"+ object.toString();

    }
}

