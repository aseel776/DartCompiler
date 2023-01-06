package flutter;

import nodes.FunctionCall;

public class Button_OnTap_functionCall extends Button_OnTap{
    public FunctionCall functionCall;
    public Button_OnTap_functionCall(FunctionCall functionCall){
        this.functionCall=functionCall;
    }

    @Override
    public String toString() {
        return "ON_TAP:" + functionCall.toString();
    }
}
