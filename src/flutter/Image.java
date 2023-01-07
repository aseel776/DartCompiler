package flutter;

import nodes.ZeroParameters;

public class Image extends Component{

    public ImageAtts imageAtts ;
    public String src;

    public Image(String src, ImageAtts imageAtts){
        super("Image", imageAtts);
        this.src = src;
        this.imageAtts = imageAtts;
    }

    public Image(String src){
        super("Image", new ZeroParameters());
        this.src = src;
    }

    @Override
    public String toString() {
        if(imageAtts != null){
            return "new Image (\n" + src + '\n' + imageAtts.toString() + "\n)";
        }
        else{
            return "new Image (\n" + src + "\n)";
        }
    }
}