package flutter;

import nodes.Node;
import nodes.Parameter;

public class Page extends Node {

    public Route route;
    public Parameter parameter;

    public Page (Route route, Parameter parameter){
        this.route = route;
        this.parameter = parameter;
    }

    public Page (Route route){
        this.route = route;
        parameter = null;
    }

    @Override
    public String toString() {
        String str = route.toString();
        if(parameter != null){
            str = str.concat(", args: " + parameter);
        }
        return str;
    }

    @Override
    public StringBuilder astImp() {
        StringBuilder str = new StringBuilder("page");
        str.append("\n\t\t").append(route.astImp());
        if(parameter != null){
            str.append("\n\t\t").append(parameter.astImp());

        }
        return str;
    }

    @Override
    public String codeGenerationImp() {
        // TODO Auto-generated method stub
        String top = "";

        if(parameter!=null){

        }
        return null;
    }
}
