package flutter;


public class Stack extends Component{
    public StackAtts stackAtts;
    public Stack(StackAtts atts){
        super("Stack", atts);
        this.stackAtts= atts;
    }
    @Override
    public String toString() {
        return "Stack:(\n"+ stackAtts.toString()+"\n);";
    }
}

