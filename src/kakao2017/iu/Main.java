package kakao2017.iu;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Arrays.stream(new int[] {
                solution.solution(15),
                solution.solution(24),
                solution.solution(41),
//                solution.solution(2147483647),
        }).forEach(answer -> {
            System.out.println(answer + "입니다.");
        });
    }
}
