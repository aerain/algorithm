package programmers.베스트앨범;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new String[] { "classic", "pop", "classic", "classic", "pop" }, new int[] { 500, 600, 150, 800, 2500 })));
    }
}
