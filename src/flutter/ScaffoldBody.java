package flutter;

public class ScaffoldBody extends ScaffoldAtts{

    public String object ;


    public  ScaffoldBody(String object ){
        super();
        this.object= object;
    }

    @Override
    public String toString() {

        return "body:" + object.toString() ;

    }
}
//    : BODY':'object COMMA?
