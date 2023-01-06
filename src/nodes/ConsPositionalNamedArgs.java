package nodes;

public class ConsPositionalNamedArgs extends ConsArgs{
    public ConsPositionalArgs posArgs;
    public ConsNamedArgs namedArgs;

    public ConsPositionalNamedArgs(ConsPositionalArgs posArgs, ConsNamedArgs namedArgs){
        this.posArgs = posArgs;
        this.namedArgs = namedArgs;
    }

    @Override
    public String toString() {
        String args = "(";
        for (int i = 0; i < posArgs.args.size(); i++){
            args = args.concat(posArgs.args.get(i).toString() + ", ");
        }
        for (int i = 0; i < namedArgs.args.size(); i++){
            if(namedArgs.args.size() == 1){
                args = args.concat("{ " + namedArgs.args.get(i).toString() + " })");
            }
            else if(i == 0){
                args = args.concat("{ " + namedArgs.args.get(i).toString() + ", ");
            } else if (i == namedArgs.args.size() - 1) {
                args = args.concat(namedArgs.args.get(i).toString() + " })");
            }else {
                args = args.concat(namedArgs.args.get(i).toString() + ", ");
            }
        }
        return args;
    }
}
