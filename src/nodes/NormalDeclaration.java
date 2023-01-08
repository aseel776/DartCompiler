package nodes;

public class NormalDeclaration extends Declaration{
    public Boolean isLate;
    public String type;
    public String id;
    public Initialization init;

    public NormalDeclaration(Boolean isLate, String type, String id, Initialization init){
        super(id);
        this.isLate = isLate;
        if(type != null){
            this.type = type;
        }
        if(init != null){
            this.init = init;
        }
    }

    @Override
    public String toString() {
        String normalDec = isLate? "late " : "";
        if(type != null){
            normalDec = normalDec.concat(type + " ");
        }
        normalDec = normalDec.concat(id + " ");
        if(init != null){
            normalDec = normalDec.concat(init.toString());
        }
        //normalDec = normalDec.concat(";");
        return normalDec;
    }
}
