package flutter;

public class PaddingAttsChild extends PaddingAtts{



    public String object ;

    public PaddingAttsChild(String object) {
        this.object = object;
    }
    @Override
    public String toString() {
        return "child:" +object.toString() ;

    }

}
