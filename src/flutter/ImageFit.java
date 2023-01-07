package flutter;

public class ImageFit extends ImageAtt{
    public String imageFit ;
    public ImageFit(String imageFit ){
        this.imageFit= imageFit;
    }

    @Override
    public String toString() {
        return "fit: " + imageFit;
    }
}
