package codewars;

import java.util.regex.Pattern;

public class CamelCase {
    public static String camelCase(String str) {
        // your code here
        return Pattern
                .compile("\\b[a-z]")
                .matcher(str.trim().toLowerCase())
                .replaceAll(matchResult -> matchResult.group().toUpperCase())
                .replaceAll(" ", "");
    }
}
