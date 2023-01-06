package flutter;

import java.util.List;

public class Costume extends Values{

    public List<CostumeValues> costumeValues;
    public Costume(List<CostumeValues> costumeValues) {
        this.costumeValues = costumeValues;
    }

    @Override
    public String toString() {
        String top= new String( "Values.costume(" )  ;
        for (int i = 0; i < costumeValues.size(); i++) {
            if (i == costumeValues.size() - 1) {
                top = top.concat(costumeValues.get(i).toString() + "\n");
            } else {
                top = top.concat(costumeValues.get(i).toString() + "," + "\n");
            }
        }
        top = top.concat(")");
        return top ;
    }
}
