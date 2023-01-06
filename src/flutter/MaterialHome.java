package flutter;

public class MaterialHome extends MaterialAppAtts{
    //%%% create  obj object------------------------------------------
    public String object ;


    public  MaterialHome(String object ){
        super();
        this.object= object;
    }

    @Override
    public String toString() {

            return "home:" + object.toString() ;

    }
}

