package flutter;

import nodes.UnnamedFunction;

public class Inkwell_OnTap_UnnamedFunction extends Inkwell_OnTap{
    public UnnamedFunction unnamedFunction;
    public Inkwell_OnTap_UnnamedFunction(UnnamedFunction unnamedFunction){
        this.unnamedFunction=unnamedFunction;
    }

    @Override
    public String toString() {
        return "ON_TAP:" + unnamedFunction.toString();
    }
}
