package nodes;

public abstract class Declaration extends Statement{
    public String id;

    public Declaration(String id){
        this.id = id;
    }
    @Override
    public String codeGenerationImp() {
        String str = "";
        str= id;
        return str;
    }
}
