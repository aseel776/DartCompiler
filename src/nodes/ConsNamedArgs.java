package nodes;

import java.util.List;

public class ConsNamedArgs extends ConsArgs{
    public List<NamedConsArg> args;

    public ConsNamedArgs(List<NamedConsArg> args){
        this.args = args;
    }

    @Override
    public String toString() {
        String namedArgs = "({";
        for (int i = 0; i < args.size(); i++){
            if(i == args.size() - 1){
                namedArgs = namedArgs.concat(args.get(i).toString());
            }else {
                namedArgs = namedArgs.concat(args.get(i).toString() + ", ");
            }
        }
        namedArgs = namedArgs.concat("})");
        return namedArgs;
    }
}
