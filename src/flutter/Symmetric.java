package flutter;

import java.util.List;

public  class Symmetric extends PaddingValues {
    public List <HorizontalOrVertical> horizontalOrVertical;

    public Symmetric(List<HorizontalOrVertical> horizontalOrVertical) {
        this.horizontalOrVertical = horizontalOrVertical;
    }


    @Override
    public String toString() {
        String top= new String( "values: PaddingValues.symmetric(" )  ;
        for (int i = 0; i < horizontalOrVertical.size(); i++) {
            if (i == horizontalOrVertical.size() - 1) {
                top = top.concat(horizontalOrVertical.get(i).toString() + "\n");
            } else {
                top = top.concat(horizontalOrVertical.get(i).toString() + "," + "\n");
            }
        }
        top = top.concat(")");
        return top ;
    }
}
