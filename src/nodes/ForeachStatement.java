package nodes;

import enums.VarOrType;

public class ForeachStatement extends Statement{

    public VarOrType type;
    public String  id;
    public String  array;
    public Block block ;

    public ForeachStatement(VarOrType type, String id, String array, Block block){
        this.type = type;
        this.id = id;
        this.array = array;
        this.block = block;
    }

    @Override
    public String toString() {
        return "forEach" + '(' + type.toString() + id + "in" + array + ')'
                + '\n' + block.toString();
    }
}
