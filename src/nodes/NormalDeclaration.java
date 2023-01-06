package nodes;

import enums.VarOrType;

public class NormalDeclaration extends Declaration{
    public Boolean isLate;
    public VarOrType type;
    public String id;
    private final Boolean isInitialized;
    public Initialization init;

    public NormalDeclaration(Boolean isLate, VarOrType type, String id, Initialization init){
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
            normalDec = normalDec.concat(type.toString() + " ");
        }
        normalDec = normalDec.concat(id + " ");
        if(isInitialized){
            normalDec = normalDec.concat(init.toString());
        }
        normalDec = normalDec.concat(";");
        return normalDec;
    }
}
