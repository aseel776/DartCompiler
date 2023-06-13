package nodes;

public abstract class Case extends Node{
    public CaseBody caseBody;

    public Case(CaseBody caseBody){
        this.caseBody = caseBody;
    }
    @Override
    public String codeGenerationImp() {
        String str = "";
        str = caseBody.codeGenerationImp();
        return str;
    }
}
