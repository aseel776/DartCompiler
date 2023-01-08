package nodes;

public class FinalDeclaration extends Declaration{
    public Boolean isLate;
    public String type;
    public Initialization init;

    public FinalDeclaration(Boolean isLate, String  type, String id, Initialization init){
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
        String finalDec = isLate? "late final " : "final ";
        if(type != null){
            finalDec = finalDec.concat(type + " ");
        }
        finalDec = finalDec.concat(id + " ");
        if(init != null){
            finalDec = finalDec.concat(init.toString());
        }
        //finalDec = finalDec.concat(";");
        return finalDec;
    }
}
