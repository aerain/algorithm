package programmers.예산;

public class Solution {
    public int solution(int[] budgets, int M) {
        long max = 0;
        int a = 0;
        int b = 0;
        for(int budget: budgets) {
            max += budget;
            b = Math.max(b, budget);
        }

        if(max <= M) return b;

        int sum, c = 0;
        int[] temp;
        while(a < b) {
            c = (a + b + 1) / 2;
            sum = 0;
            temp = new int[budgets.length];
            for(int i = 0; i < temp.length; i++) {
                temp[i] = Math.min(budgets[i], c);
            }
            for(int budget: temp) sum += budget;

            if(sum > M) {
                b = c - 1;
            } else {
                a = c;
            }
        }
        return a;
    }
}
