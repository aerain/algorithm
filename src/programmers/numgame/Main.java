package programmers.numgame;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(
                new int[] { 5, 1, 3, 7 },
                new int[] { 8, 2, 6, 2 }
        ));
        System.out.println(solution.solution(
                new int[] { 2, 2, 2, 2 },
                new int[] { 1, 1, 1, 1 }
        ));
    }
}
