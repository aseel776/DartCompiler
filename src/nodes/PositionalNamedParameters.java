package nodes;

public class PositionalNamedParameters extends Parameters{
    public PositionalParameters positionalParameters;
    public NamedParameters namedParameters;

    public PositionalNamedParameters(PositionalParameters positionalParameters, NamedParameters namedParameters){
        this.positionalParameters = positionalParameters;
        this.namedParameters = namedParameters;
    }

    @Override
    public String toString() {
        String pars = "(";
        for (int i = 0; i < positionalParameters.parameters.size(); i++){
            pars = pars.concat(positionalParameters.parameters.get(i).toString() + ", ");
        }
        for (int i = 0; i < namedParameters.parameters.size(); i++){
            if(namedParameters.parameters.size() == 1 || i == namedParameters.parameters.size() - 1){
                pars = pars.concat(namedParameters.parameters.get(i).toString() + " )");
            }else {
                pars = pars.concat(namedParameters.parameters.get(i).toString() + ", ");
            }
        }
        return pars;
    }
}
