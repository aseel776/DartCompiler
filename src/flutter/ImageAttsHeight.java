package flutter;

import nodes.DartInteger;

public class ImageAttsHeight extends ImageAtt{
    DartInteger number ;
    public ImageAttsHeight(DartInteger number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "imageHeight: " + number.toString();
    }
}
