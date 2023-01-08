package nodes;

public class FinalDeclaration extends Declaration{
    public Boolean isLate;
    public String type;
    public String id;
    private final Boolean isInitialized;
    public Initialization init;

    public FinalDeclaration(Boolean isLate, String  type, String id, Initialization init){
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
            finalDec = finalDec.concat(type + " ");
        }
        finalDec = finalDec.concat(id + " ");
        if(isInitialized){
            finalDec = finalDec.concat(init.toString());
        }
        //finalDec = finalDec.concat(";");
        return finalDec;
    }
}
