package codewars.java;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class Transpiler {
    public static String transpile (String expression) {
        System.out.println("original is \n" + expression);
        Map<String, String> map = new HashMap<>();
        expression = Pattern.compile("\\s+").matcher(expression).replaceAll("");

        System.out.println("removed whitespace\n" + expression);
        return "";
    }
}
