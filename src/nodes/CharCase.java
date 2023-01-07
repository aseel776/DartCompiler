package nodes;

public class CharCase extends Case{
    public String str;

    public CharCase(String str, CaseBody caseBody){
        super(caseBody);
        this.str = str;
    }

    @Override
    public String toString() {
        return "case " + "\"" + str + "\"" + ':' + caseBody.toString();
    }
}
