package flutter;

import nodes.DartInteger;

public class Top extends CostumeValues{

    DartInteger number;

    public Top(DartInteger number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "top:"+number.toString();
    }

    @Override
    public StringBuilder astImp() {
        return new StringBuilder(toString());
    }
}
