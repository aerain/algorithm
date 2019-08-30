package programmers.kakao2018.first.실패율;

import java.util.*;

public class Solution {
    public int[] solution(int N, int[] stages) {
        int[] states = new int[N + 1];
        Map<Integer, Double> fail = new HashMap<>();
        for(int stage: stages) states[stage - 1]++;
        int acc = states[states.length - 1];
        for(int i = states.length - 2; i > -1; i--) {
            acc += states[i];
            fail.put(i + 1, acc > 0 ? ((double) states[i] / (double) acc) : 0);
        }
        List<Integer> list = new ArrayList<>(fail.keySet());
        list.sort((o1, o2) -> -Double.compare(fail.get(o1), fail.get(o2)));
        int[] answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++) answer[i] = list.get(i);
        return answer;
    }
}
