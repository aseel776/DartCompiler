package nodes;

import java.util.List;

public class ClassBody extends Node{
    public List<ClassAttribute> attributes;
    public List<ClassMethod> methods;
    public DefaultConstructor defaultConstructor;

    public ClassBody(List<ClassAttribute> attributes, List<ClassMethod> methods, DefaultConstructor defaultConstructor){
        this.attributes = attributes;
        this.methods = methods;
        if(defaultConstructor != null){
            this.defaultConstructor = defaultConstructor;
        }
    }

    @Override
    public String toString() {
        String body = "{ \n";
        for (ClassAttribute att: attributes) {
            body = body.concat(att.toString()) + "; \n";
        }
        if(defaultConstructor != null){
            body = body.concat(defaultConstructor.toString() + '\n');
        }
        for (ClassMethod method: methods) {
            body = body.concat(method.toString() + '\n');
        }
        body = body.concat("}");
        return body;
    }
}
