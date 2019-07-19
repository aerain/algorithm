package kakao2017.meeting;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {
    public int[] solution(int m, int n, int s, int[][] time_map) {
        int moveDistance = Integer.MAX_VALUE;
        int sumOfTalkTime = Integer.MAX_VALUE;

        // 2501은 최대값이 50 * 50이기 때문에 거리가 0부터 2500까지의 최대가능한 경우를 모두 구하기 위함.

        int[][][] S = new int[m][n][2501];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(S[0][0]);

        int[] answer = new int[2];
        answer[0] = moveDistance;
        answer[1] = sumOfTalkTime;

        return answer;
    }
}

