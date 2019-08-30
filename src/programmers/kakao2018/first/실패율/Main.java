package programmers.kakao2018.first.실패율;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(5, new int[] { 2, 1, 2, 6, 2, 4, 3, 3 })));
        System.out.println(Arrays.toString(solution.solution(4, new int[] { 4, 4, 4, 4, 4 })));
        System.out.println(Arrays.toString(solution.solution(4, new int[] { 2, 2, 2, 1, 1 })));
    }
}
