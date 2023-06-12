package nodes;

public abstract class Node {
    public int objectHash = 0;

    abstract public StringBuilder astImp();

    abstract public String codeGenerationImp();

    public String setWidgetName(String name, Integer code) {
        return "name=' " + name + " " + code + "'";
    }

    public String setClassName(String name) {
        return "class='" + name + "'";
    }

    public String setClassesNames(String[] classes) {
        StringBuilder top = new StringBuilder();
        top.append("class='");
        for (String s : classes) {
            top.append(s);
        }
        top.append("'");
        return top.toString();
    }

    public String printLine(String str) {
        return str.concat("\n");
    }

    public String setClassNameByJs(String className) {
        return "classList.add('" + className + "'')";
    }
}
