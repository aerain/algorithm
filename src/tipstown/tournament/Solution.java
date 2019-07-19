package tipstown.tournament;

public class Solution {
    public int solution(int n, int a, int b) {
        if(a > b) {
            int temp = b;
            b = a;
            a = temp;
        }


        while(!((n / 2) >= a && (n / 2) < b)) n /= 2;
        return (int) (Math.log(n) / Math.log(2));

        /**
         *
         * 4 7
         * 2 3
         * 1 2
         *
         * 2 14
         * 1
         */
    }
}
