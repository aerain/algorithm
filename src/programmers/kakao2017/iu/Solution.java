package programmers.kakao2017.iu;

public class Solution {
    public int solution(int n) {
        if(n % 2 == 0) return 0;
        int answer = 0;

        return answer;
    }

    private int getBasePitch(int exp) {
        return (int) Math.pow(3, exp) + 2 * exp;
    }
}
