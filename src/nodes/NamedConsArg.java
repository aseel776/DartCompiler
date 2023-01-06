package nodes;

import enums.TypeOrThis;

public class NamedConsArg extends ConsArg {
    public Boolean isRequired;

    public NamedConsArg(Boolean isRequired, TypeOrThis type, String id){
        super(type, id);
        this.isRequired = isRequired;
    }

    @Override
    public String toString() {
        String arg = isRequired ? "required " : "" ;
        if(type != null){
            if(type == TypeOrThis.THIS){
                arg = arg.concat("this." + id);
            }else{
                arg = arg.concat(type.toString() + " " + id);
            }
        }else{
            arg = arg.concat(id);
        }
        return arg;
    }
}
