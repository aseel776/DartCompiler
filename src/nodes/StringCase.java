package nodes;

public class StringCase extends Case{
    public String str;

    public StringCase(String str, CaseBody caseBody){
        super(caseBody);
        this.str = str;
    }

    @Override
    public String toString() {
        return "case " + "\"" + str + "\"" + ':' + caseBody.toString();
    }
}
