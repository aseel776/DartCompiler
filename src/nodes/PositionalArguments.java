package nodes;

import java.util.List;

public class PositionalArguments extends Arguments{
    public List<Argument> args;

    public PositionalArguments(List<Argument> args){
        this.args = args;
    }

    @Override
    public String toString() {
        String posArgs = "(";
        for (int i = 0; i < args.size(); i++){
            if(i == args.size() - 1){
                posArgs = posArgs.concat(args.get(i).toString());
            }else {
                posArgs = posArgs.concat(args.get(i).toString() + ", ");
            }
        }
        posArgs = posArgs.concat(")");
        return posArgs;
    }
}
