package programmers.kakao2017.third.압축;

import java.util.*;

public class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> dict = new HashMap<>();
        for(char c = 'A'; c <= 'Z'; c++) {
            dict.put(String.valueOf(c), dict.size() + 1);
        }
        List<Integer> list = new ArrayList<>();
        int startIndex = 0, endIndex = 1;
        String temp = null, prev;
        while(startIndex <= msg.length() && endIndex <= msg.length()) {
            while(endIndex <= msg.length()) {
                prev = temp;
                temp = msg.substring(startIndex, endIndex);
                if(dict.getOrDefault(temp, -1) == -1) {
                    list.add(dict.get(prev));
                    dict.put(temp, dict.size() + 1);
                    break;
                } else {
                    endIndex++;
                    if(endIndex > msg.length()) list.add(dict.get(temp));
                }
            }

            startIndex = endIndex - 1;
            endIndex = startIndex + 1;
        }

        int[] answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++) answer[i] = list.get(i);
        return answer;
    }
}
