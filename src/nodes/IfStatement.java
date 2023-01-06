package nodes;

import java.util.ArrayList;
import java.util.List;

public class IfStatement extends Statement{
    public Condition condition;
    public Block block;
    public List<ElseIf> elseIfs;
    public Else anElse;

    public IfStatement(Condition condition, Block block, List<ElseIf> elseIfs, Else anElse){
        this.condition = condition;
        this.block = block;
        this.elseIfs = new ArrayList<>();
        if(elseIfs != null){
            this.elseIfs = elseIfs;
            this.anElse = anElse;
        }
        else {
            if (anElse != null){
                this.anElse = anElse;
            }
        }
    }

    @Override
    public String toString() {
        if (elseIfs != null){
            String wholeIf = "if" + '(' + condition.toString() + ')' + '\n' + block.toString() + '\n' ;
            for (ElseIf elseIf: elseIfs) {
                wholeIf = wholeIf.concat(elseIf.toString() + '\n');
            }
            wholeIf = wholeIf.concat(anElse.toString());
            return wholeIf;
        }else {
            if (anElse != null){
                return "if" + '(' + condition.toString() + ')' + '\n' + block.toString() + '\n' + anElse.toString();
            }else {
                return "if" + '(' + condition.toString() + ')' + '\n' + block.toString();
            }
        }
    }
}
