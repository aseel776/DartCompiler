package nodes;

public class DartClass extends Node {
    public Boolean isAbstract;
    public String id;
    public String superClass;
    public String impInterface;
    public ClassBody classBody;

    public DartClass(Boolean isAbstract, String id, String superClass, String impInterface, ClassBody classBody){
        this.isAbstract = isAbstract;
        this.id = id;
        if(superClass != null){
            this.superClass = superClass;
        }
        if(impInterface != null) {
            this.impInterface = impInterface;
        }
        this.classBody = classBody;
    }

    @Override
    public String toString() {
        String wholeClass;
        if(isAbstract){
           wholeClass = "abstract class" + " " + id + " ";
        }else {
            wholeClass = "class" + " " + id + " ";
        }
        if(superClass != null){
            wholeClass = wholeClass.concat("extends" + " " + superClass + " ");
        }
        if(impInterface != null){
            wholeClass = wholeClass.concat("implements" + " " + impInterface + " ");
        }
        wholeClass = wholeClass.concat(classBody.toString());
        return wholeClass;
    }
}
