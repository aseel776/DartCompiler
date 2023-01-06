package nodes;

import java.util.List;

public class NamedParameters extends Parameters{
    public List<NamedParameter> parameters;

    public NamedParameters(List<NamedParameter> parameters){
        this.parameters = parameters;
    }

    @Override
    public String toString() {
        String pars = "(";
        for (int i = 0; i < parameters.size(); i++){
            if(i == parameters.size() - 1){
                pars = pars.concat(parameters.get(i).toString() + ")");
            }else{
                pars = pars.concat(parameters.get(i).toString() + ", ");
            }
        }
        return pars;
    }
}
