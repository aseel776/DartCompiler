package nodes;

public class CaseBody extends Block{
    public Boolean containsBreak;

    public CaseBody(Boolean containsBreak){
        super();
        this.containsBreak = containsBreak;
    }

    @Override
    public String toString() {
        String body = new String("{");
        for (Node n : statements) {
            body = body.concat('\n' + n.toString());
        }
        if(containsBreak){
            body = body.concat('\n' + "break;");
        }
        body = body.concat("\n }");
        return body;
    }
}