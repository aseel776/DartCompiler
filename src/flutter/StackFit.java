package flutter;
//import enums.StackFit;

public class StackFit extends StackAtt{
    public enums.StackFit stackFit ;
    public StackFit(enums.StackFit stackFit ){
        this.stackFit= stackFit;
    }
    @Override
    public String toString() {
        return  "fit:StackFit."+stackFit.toString();
    }
}
//    : FIT':'STACK_FIT COMMA?
