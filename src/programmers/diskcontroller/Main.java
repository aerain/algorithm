package programmers.diskcontroller;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new int[][] {
                {0, 3},
                {1, 9},
                {2, 6}
        });
        solution.solution(new int[][] {
                {0, 5},
                {1, 2},
                {5, 5}
        });
        solution.solution(new int[][] {
                {0, 9},
                {0, 4},
                {0, 5},
                {0, 7},
                {0, 3}
        });
        solution.solution(new int[][] {
                {1, 4},
                {5, 2},
                {10, 3}
        }); // 9 / 3 = 3
    }
}
