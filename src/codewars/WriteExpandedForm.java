package codewars;

public class WriteExpandedForm {
    public static String expandedForm(int num) {
        int digits = (int) Math.log10(num);
        StringBuilder sb = new StringBuilder();
        for(int i = digits; i >= 0; i--) {
            int pow = (int) Math.pow(10, i);
            if(num / pow == 0) continue;
            if(sb.length() != 0) sb.append(" + ");
            sb.append((num / pow) * pow);
            num %= pow;
        }
        return sb.toString();
    }
}
