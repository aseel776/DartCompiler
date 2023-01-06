package flutter;


import nodes.DartObject;


public class SizedBoxChild extends SizedBoxAtt{
    DartObject object;
    public SizedBoxChild(DartObject object){
        this.object=object;
    }

    @Override
    public String toString() {
        return "child:" +object.toString();
    }
}