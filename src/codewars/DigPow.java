package codewars;

public class DigPow {
    public static long digPow(int n, int p) {
        int temp = n;
        int length = (int) Math.log10(n);
        int result = 0;
        for(int i = p + length; i >= p; i--) {
            result += Math.pow(temp % 10, i);
            temp /= 10;
        }
        return result % n == 0 ? result / n : -1;
    }
}
