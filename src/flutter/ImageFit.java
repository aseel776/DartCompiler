package flutter;

import enums.BoxFit;

public class ImageFit extends ImageAtt{
    public BoxFit imageFit ;
    public ImageFit(enums.BoxFit imageFit ){
        this.imageFit= imageFit;
    }

    @Override
    public String toString() {
        return  "fit:BoxFit."+imageFit.toString();
    }
}
