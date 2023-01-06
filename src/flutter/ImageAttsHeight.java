package flutter;

import nodes.PositiveInteger;

public class ImageAttsHeight extends ImageAtt{
    PositiveInteger number ;
    public ImageAttsHeight(PositiveInteger number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "height:"+number.toString();
    }
}
