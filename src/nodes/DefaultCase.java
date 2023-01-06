package nodes;

public class DefaultCase extends Case{

    public DefaultCase(CaseBody caseBody){
        super(caseBody);
    }

    @Override
    public String toString() {
        return "default: " + caseBody.toString();
    }
}
