package programmers.kakao2017.mysteryadventure;

class Solution {
    public int solution(int n1, int[][] g1, int n2, int[][] g2) {
        int answer = 0;

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // expected: 7
        System.out.println(solution.solution(8, new int[][]{
                {3, 1},
                {5, 7},
                {8, 7},
                {2, 3},
                {3, 6},
                {1, 5},
                {4, 3}
        }, 9, new int[][]{
                {1, 5},
                {5, 6},
                {3, 7},
                {3, 1},
                {7, 4},
                {7, 2},
                {9, 8},
                {5, 9}
        }));
    }
}
