package nodes;

public class SwitchStatement extends Statement{
    public String id;
    public SwitchBody body;

    public SwitchStatement(String id, SwitchBody body){
        this.id = id;
        this.body = body;
    }

    @Override
    public String toString() {
        return "switch" + '(' + id + ')' + body.toString();
    }
}
