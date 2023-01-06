package flutter;

public class MaterialTitle extends MaterialAppAtt{
    public String title;

    public MaterialTitle(String character){
        super();
        this.title= character;

    }

    @Override
    public String toString() {

        return "title:"+title;
    }
}

