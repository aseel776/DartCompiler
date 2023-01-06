package flutter;

import nodes.DartObject;

public class MaterialHome extends MaterialAppAtt{
    public DartObject object ;

    public  MaterialHome(DartObject object ){
        super();
        this.object= object;
    }

    @Override
    public String toString() {
        return "home:" + object.toString() ;
    }
}

