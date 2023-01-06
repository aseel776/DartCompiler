package flutter;

import nodes.DartObject;

public class ScaffoldBody extends ScaffoldAtt{

    public DartObject object ;


    public  ScaffoldBody(DartObject object ){
        super();
        this.object= object;
    }

    @Override
    public String toString() {
        return "body:" + object.toString() ;
    }
}
