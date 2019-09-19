package programmers.kakao2018.first.무지의먹방라이브;

import java.util.*;

public class Solution {
    public int solution(int[] food_times, long k) {
        int length = food_times.length;
        int min;
        while(length > 0) {
            min = Integer.MAX_VALUE;
            for(int time: food_times) if(time != 0) min = Math.min(min, time);
            // 최소가 k보다 작으면? 하나 0때리고 길이 하나 줄이고 다시 재개!
            if(min * length < k) {
                for(int i = 0; i < food_times.length; i++) {
                    if(food_times[i] == 0) continue;
                    food_times[i] -= min;
                    if(food_times[i] == 0) length--;
                }
                k -= min * length; // 남은시간도 줄이고
            } else { // 그렇지 않다면. 드디어 올때가 왔다.
                k %= length;
                if(k == 0) k = length;
                k--;

                System.out.println(k+ "번째");
                int i = 0;
                while(k > 0) {
                    i++;
                    if(food_times[i] != 0) k--;
                }
                return i + 1;
            }
        }
        return -1;
    }
}
