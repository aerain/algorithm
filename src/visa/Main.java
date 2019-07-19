package visa;

import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int n = citations.length;
        Arrays.sort(citations);
        for(int i = n - 1; i >= 0; i--) {
            final int h = citations[i];
            if(n - h + 1 >= h &&
                Arrays.stream(Arrays.copyOfRange(citations, i, n)).allMatch(cit -> cit >= h) &&
                Arrays.stream(Arrays.copyOfRange(citations, 0, i)).allMatch(cit -> cit <= h)) {
                answer = h;
                break;
            }

        }
        return answer;
    }

}
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[] { 3, 0, 6, 1, 5}));
    }
}
