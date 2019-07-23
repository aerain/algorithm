package programmers.summer2018.edit_terrain;
class Solution {
    public long solution(int[][] land, int P, int Q) {
        long answer = Long.MAX_VALUE;
        long max = 1000000000;
        long sum;
        long idx = 0L;
        while(true) {
            sum = 0L;
            for (int[] rows : land) {
                for (long floor : rows) {
                    sum += (idx >= floor) ? (idx - floor) * (long) P : (floor - idx) * (long) Q;
                }
            }
            if (answer < sum) break;
            answer = sum;
            idx = (idx + max) / 2;
        }
        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[][] {
                {1, 2},
                {2, 3}
        }, 3, 2));
        System.out.println();
        System.out.println(solution.solution(new int[][] {
                {4, 4, 3},
                {3, 2, 2},
                {2, 1, 0}
        }, 5, 3));
        System.out.println();
        System.out.println(solution.solution(new int[][] {
                {1000000000, 999999999, 1000000000},
                {1000000000, 999999999, 1000000000},
                {1000000000, 999999999, 1000000000}
        }, 1, 4));
    }
}
