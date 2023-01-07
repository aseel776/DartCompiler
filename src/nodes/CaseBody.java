package nodes;

public class CaseBody extends Block{
    public Boolean containsBreak;

    public CaseBody(Boolean containsBreak){
        super();
        this.containsBreak = containsBreak;
    }

    @Override
    public String toString() {
        String body = "\n";
        for (Node n : statements) {
            body = body.concat(n.toString() + '\n');
        }
        if(containsBreak){
            body = body.concat("break;");
        }
        return body;
    }
}