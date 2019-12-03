package codewars.java;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Runes {
    public static int solveExpression( final String expression ) {
        boolean[] history = new boolean[10];
        for(char ch: expression.toCharArray()) {
            if(ch == '?' || ch == '=' || ch == '*' || ch == '+' || ch == '-' || ch == '/') continue;
            history[Character.compare(ch, '0')] = true;
        }
        Matcher m = Pattern.compile("((?<=[\\d?])[-+*/=])|((?<!\\d)-[\\d?]+)|([\\d?]*)").matcher(expression);
        m.find();
        String as = m.group();
        m.find();
        String op = m.group();
        m.find();
        String bs = m.group();
        m.find();
        m.group();
        m.find();
        String cs = m.group();

        int missingDigit;
        for(missingDigit = 0; missingDigit <= 9; missingDigit++) {
            if(history[missingDigit]) continue;
            int a = Integer.parseInt(as.replace("?", String.valueOf(missingDigit)));
            int b = Integer.parseInt(bs.replace("?", String.valueOf(missingDigit)));
            int c = Integer.parseInt(cs.replace("?", String.valueOf(missingDigit)));
            if(missingDigit == 0 && ((as.length() != 1 && as.startsWith("?")) || (bs.length() != 1 && bs.startsWith("?")) || (cs.length() != 1 && cs.startsWith("?"))))
                continue;
            int answer = -1;
            switch(op) {
                case "+": answer = a + b; break;
                case "-": answer = a - b; break;
                case "*": answer = a * b; break;
                case "/": answer = a / b; break;
                default: break;
            }
            if(answer == c) {
                break;
            }
        }
        return missingDigit == 10 ? -1 : missingDigit;
    }
}
