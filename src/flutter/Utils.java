
package flutter;

public class Utils {
    public static String setWidgetName(String name, Integer code) {
        return "name=' " + name + " " + code + "'";
    }

    public static String setClassName(String name) {
        return "class='" + name + "'";
    }

    public static String setClassesNames(String[] classes) {
        StringBuilder top = new StringBuilder();
        top.append("class='");
        for (String s : classes) {
            top.append(s);
        }
        top.append("'");
        return top.toString();
    }

    public static String printLine(String str) {
        return str.concat("\n");
    }

    public static String setClassNameByJs(String className) {
        return "classList.add('" + className + "'')";
    }
}
