package nodes;

public class ForeachStatement extends Statement{

    public String type;
    public String  id;
    public Variable list;
    public Block block ;

    public ForeachStatement(String type, String id, Variable list, Block block){
        this.type = type;
        this.id = id;
        this.list = list;
        this.block = block;
    }

    @Override
    public String toString() {
        return "foreach" + '(' + type + " " + id + " in " + list.toString() + ')'
                + '\n' + block.toString();
    }
}
