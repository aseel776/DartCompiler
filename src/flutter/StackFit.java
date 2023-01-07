package flutter;
//import enums.StackFit;

public class StackFit extends StackAtt{
    public String stackFit ;
    public StackFit(String stackFit ){
        this.stackFit= stackFit;
    }
    @Override
    public String toString() {
        return  "fit: " + stackFit;
    }
}
//    : FIT':'STACK_FIT COMMA?
