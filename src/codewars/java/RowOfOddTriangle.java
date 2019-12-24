package codewars.java;

public class RowOfOddTriangle {
    public static long[] oddRow(int n) {
//        if(n == 1) return new long[] { 1 };
        /*
        1, 3, 7, 13, 21
        1
        1 + 2 = 3
        3 + 4 = 7
        7 + 6 = 13
        13 + 8 = 21
         */

        long start = 1;
        for(int i = 0; i < n; i++) {
            start = start + (2 * i);
        }
        long[] answer = new long[n];
        for(int i = 0; i < n; i++) {
            answer[i] = start + (i * 2);
        }
        return answer;
    }
}
