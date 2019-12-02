package codewars;

public class SimilarSameDigit {
    public static long nextSmaller(long n) {
        char[] arr = String.valueOf(n).toCharArray();
        /*
            ABAB이면 A를 고를확률 -> 1번째 인덱스 AA -> 1번째 인덱스 - AAB 를 고를확률 1 -> AABB 1
                                           AB -> AA까지의 모든 겨웅의수 + 1 - ABA, ABAB
            AABB -> ABAB

            BOOKKEEPER => B, BE, BEE, BEEE, BEEEK, BEEEKK, BEEE
        */
        return n;
    }

    public static long factorial(long n) {
        if(n == 1) return 1;
        int result = 1;
        for(int i = 2; i <= n; i++) result*=i;
        return result;
    }
}
