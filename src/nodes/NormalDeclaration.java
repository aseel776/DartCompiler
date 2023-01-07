package nodes;

public class NormalDeclaration extends Declaration{
    public Boolean isLate;
    public String type;
    public String id;
    private final Boolean isInitialized;
    public Initialization init;

    public NormalDeclaration(Boolean isLate, String type, String id, Initialization init){
        this.isLate = isLate;
        if(type != null){
            this.type = type;
        }
        this.id = id;
        if(init != null){
            isInitialized = true;
            this.init = init;
        }else{
            this.isInitialized = false;
        }
    }

    @Override
    public String toString() {
        String normalDec = isLate? "late " : "";
        if(type != null){
            normalDec = normalDec.concat(type + " ");
        }
        normalDec = normalDec.concat(id + " ");
        if(isInitialized){
            normalDec = normalDec.concat(init.toString());
        }
        normalDec = normalDec.concat(";");
        return normalDec;
    }
}
