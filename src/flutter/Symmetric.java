package flutter;

import java.util.List;

public  class Symmetric extends Values {
    public List <HorizontalOrVertical> horizontalOrVertical;

    public Symmetric(List<HorizontalOrVertical> horizontalOrVertical) {
        this.horizontalOrVertical = horizontalOrVertical;
    }


    @Override
    public String toString() {
        String top= new String( "Values.symmetric(" )  ;
        for (int i = 0; i < horizontalOrVertical.size(); i++) {
            if (i == horizontalOrVertical.size() - 1) {
                top = top.concat(horizontalOrVertical.toString() + "\n");
            } else {
                top = top.concat(horizontalOrVertical.toString() + "," + "\n");
            }
        }
        top = top.concat(")");
        return top ;
    }
}
//    | SYMMETRIC '(' horizontalOrVertical+ ')' //values.symmetric(horizontal: 4, vertical: 8)
