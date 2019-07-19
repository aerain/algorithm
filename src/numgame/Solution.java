package numgame;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        if(Arrays.stream(A).parallel().min().getAsInt() >= Arrays.stream(B).parallel().max().getAsInt()) return 0;
        return answer;
    }
}
