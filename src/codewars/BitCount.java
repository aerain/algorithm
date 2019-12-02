package codewars;

import java.math.BigInteger;
import java.util.stream.LongStream;

public class BitCount {

    public static BigInteger countOnes(long left, long right) {
        // Your code here
        System.out.println(Long.toBinaryString(left));
        System.out.println(Long.toBinaryString(right));


        return BigInteger.valueOf(LongStream.rangeClosed(left, right).parallel().map(Long::bitCount).sum());
    }
}