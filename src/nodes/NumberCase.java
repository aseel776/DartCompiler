package nodes;

public class NumberCase extends Case{
    public Number number;

    public NumberCase(Number number, CaseBody caseBody){
        super(caseBody);
        this.number = number;
    }

    @Override
    public String toString() {
        return "case " + number.toString() + ':' + caseBody.toString();
    }
}
