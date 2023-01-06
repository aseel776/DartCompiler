package nodes;

import enums.Type;

public class FinalDeclaration extends Declaration{
    public Boolean isLate;
    public Type type;
    public String id;
    private final Boolean isInitialized;
    public Initialization init;

    public FinalDeclaration(Boolean isLate, Type type, String id, Initialization init){
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
        String finalDec = isLate? "late final " : "final ";
        if(type != null){
            finalDec = finalDec.concat(type.toString() + " ");
        }
        finalDec = finalDec.concat(id + " ");
        if(isInitialized){
            finalDec = finalDec.concat(init.toString());
        }
        finalDec = finalDec.concat(";");
        return finalDec;
    }
}
