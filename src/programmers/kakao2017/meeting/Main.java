package programmers.kakao2017.meeting;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Arrays.stream(new int[][] {
                solution.solution(3, 3, 150, new int[][] {
                        {0,   2,   99},
                        {100, 100, 4 },
                        {1,   2,   0 }
                }),
                solution.solution(4, 6, 25, new int[][]{
                        { 0, 1,  1, -1, 2, 4},
                        {-1, 7,  2,  1, 5, 7},
                        {-1, 1, -1,  1, 6, 3},
                        {-1, 1, -1, -1, 7, 0}
                }),
                solution.solution(5, 5, 12, new int[][]{
                        {0, 1, 1, 1, 1},
                        {9, 9, 9, 1, 9},
                        {1, 1, 1, 1, 9},
                        {1, 1, 5, 9, 9},
                        {1, 1, 1, 1, 0}
                })
        }).forEach(ints -> System.out.println(Arrays.toString(ints)));
    }
}
