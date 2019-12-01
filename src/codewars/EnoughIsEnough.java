package codewars;

import java.util.*;

public class EnoughIsEnough {
    public static int[] deleteNth(int[] elements, int maxOccurrences) {
        //Code here ;)
        Map<Integer, Integer> history = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int element: elements) {
            int times = history.getOrDefault(element, 0);
            if(times < maxOccurrences) {
                list.add(element);
                history.put(element, times + 1);
            }
        }
        int[] answer = new int[list.size()];
        int index = 0;
        for(int num: list) answer[index++] = num;
        return answer;
    }
}
