package codewars;

import java.math.BigInteger;

public class Faberge {
    public static BigInteger height(BigInteger n, BigInteger m) {
        if(n.equals(BigInteger.ZERO) || m.equals(BigInteger.ZERO)) return BigInteger.ZERO;
        if(m.equals(BigInteger.ONE)) return m;
        if(n.equals(BigInteger.ONE)) return BigInteger.ONE;

        // 16 * 13
                // 1 -> 34 -> 68 -> 54 ->
        return BigInteger.TWO; // TODO replace with your solution
    }
}
