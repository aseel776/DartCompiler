package nodes;

public class SwitchStatement extends Statement{
    public Variable id;
    public SwitchBody body;

    public SwitchStatement(Variable id, SwitchBody body){
        this.id = id;
        this.body = body;
    }

    @Override
    public String toString() {
        return "switch" + '(' + id + ')' + body.toString();
    }
}
