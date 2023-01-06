package flutter;

public class MaterialTitle extends MaterialAppAtts{
    public String character;

    public MaterialTitle(String character){
        super();
        this.character= character;

    }

    @Override
    public String toString() {

        return "title:"+character;
    }
}

