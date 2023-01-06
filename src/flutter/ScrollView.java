package flutter;

public class ScrollView extends Component{
    public ScrollViewAtts scrollViewAtts ;

    public ScrollView(ScrollViewAtts scrollViewAtts){
        super("ScrollView", scrollViewAtts);
        this.scrollViewAtts= scrollViewAtts;
    }

    @Override
    public String toString() {
        return "new ScrollView (\n" + scrollViewAtts.toString() + "\n)";
    }

}
