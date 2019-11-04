package programmers.기능개발;

import java.util.Arrays;

public class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        for(int i = 0; i < progresses.length; i++) {
            int rest = (100 - progresses[i]) / speeds[i];
            progresses[i] = (i > 0 && progresses[i - 1] > rest) ? progresses[i - 1] : rest;
        }
        int[] answer = new int[progresses[progresses.length - 1]];
        for(int i = 0; i < answer.length; i++) {
            int index = i + 1;
            int count = 0;
            for(int j = 0; j < progresses.length; j++) {
                if(progresses[j] == index) count++;
            }
            answer[i] = count;
        }
        return Arrays.stream(answer).filter(i -> i != 0).toArray();
    }
}
