package nodes;

import java.util.List;

public class IfStatement extends Statement{

    public Condition condition;
    public Block block;
    public List<ElseIf> elseIfs;
    public Else anElse;

    public IfStatement(Condition condition, Block block, List<ElseIf> elseIfs, Else anElse){
        this.condition = condition;
        this.block = block;
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

    @Override
    public StringBuilder astImp() {
        StringBuilder str = new StringBuilder("if");
        str.append("\n\t\t").append(condition.astImp());
        str.append("\n\t\t").append(block.astImp());
        if(elseIfs != null){
            for (ElseIf elseIf: elseIfs){
                str.append("\n\t\t").append(elseIf.astImp());
            }
            str.append("\n\t\t").append(anElse.astImp());
        }else{
            if(anElse != null){
                str.append("\n\t\t").append(anElse.astImp());
            }
        }
        return str;
    }
}
