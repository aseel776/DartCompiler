package flutter;

import nodes.DartObject;

public class ButtonChild extends ButtonAtt{
    DartObject object;
    public ButtonChild(DartObject object){
        this.object=object;
    }

    @Override
    public String toString() {
        return "buttonChild:" +object.toString();
    }
}
