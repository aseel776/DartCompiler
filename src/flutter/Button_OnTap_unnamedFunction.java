package flutter;

import nodes.UnnamedFunction;

public class Button_OnTap_unnamedFunction extends Button_OnTap{
   public UnnamedFunction unnamedFunction;
   public Button_OnTap_unnamedFunction(UnnamedFunction unnamedFunction){
       this.unnamedFunction=unnamedFunction;
   }

    @Override
    public String toString() {
        return "buttonOnTap: " + unnamedFunction.toString();
    }
}
