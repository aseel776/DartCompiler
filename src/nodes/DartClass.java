package nodes;

public class DartClass extends Node {
    public Boolean isAbstract;
    public String id;
    private final Boolean extendsAClass;
    public String superClass;
    private final Boolean implementsAnInterface;
    public String impInterface;
    public ClassBody classBody;

    public DartClass(Boolean isAbstract, String id, String superClass, String impInterface, ClassBody classBody){
        this.isAbstract = isAbstract;
        this.id = id;
        if(superClass != null){
            this.superClass = superClass;
            extendsAClass = true;
        }else{
            extendsAClass = false;
        }
        if(impInterface != null) {
            this.impInterface = impInterface;
            implementsAnInterface = true;
        }else{
            implementsAnInterface = false;
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
        if(extendsAClass){
            wholeClass = wholeClass.concat("extends" + " " + superClass + " ");
        }
        if(implementsAnInterface){
            wholeClass = wholeClass.concat("implements" + " " + impInterface + " ");
        }
        wholeClass = wholeClass.concat(classBody.toString());
        return wholeClass;
    }
}
