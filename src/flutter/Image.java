package flutter;

public class Image extends Component{
    public ImageAtts imageAtts ;
    public String src;
    public Image(String src, ImageAtts imageAtts){
        super("Image", imageAtts);
        this.src = src;
        this.imageAtts = imageAtts;
    }

    @Override
    public String toString() {
        return "new Image (\n" + src + '\n' + imageAtts.toString() + "\n)";
    }
}