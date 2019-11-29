package programmers.징검다리;

import java.util.Arrays;

public class Solution {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        int a = 0;
        int b = distance;

        while(a < b) {
            // 거리의 중간값을 찾는다.
            int c = (a + b + 1) / 2;

            // 임의의 돌위치를 초기화한다.
            int p = 0;

            // ? 뭐하시는 분?
            int hits = 0;

            // 순차탐색 실시
            for(int i = 0; i < rocks.length; i++) {
                // 거리 중간값보다 적은 수만큼 히트하고
                if(rocks[i] - p < c) {
                    hits += 1;
                } else {
                    // 돌과의 거리가 최종 거리보다 커져버리면 p를 옮겨서 재실시.
                    p = rocks[i];
                }
            }

            // 히트한 수가 제거할 돌 수보다 크다면? 왼쪽에서 재탐색
            if(hits > n) {
                b = c - 1;
            } else {
                // 그렇지않으면 오른쪽 재탐색
                a = c;
           }
        }
        return a;
    }
}
