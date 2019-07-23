package programmers.tipstown.pair;

import java.util.*;

class Solution {
    public int solution(String s) {
        Set<Integer> history = new HashSet<>();
        char[] ch = s.toCharArray();
        boolean empty = false;
        boolean needCheck = true;
        int lastIndex = -1;
        while(needCheck) {
            if(history.size() == ch.length) return 1;
            needCheck = false;

            for(int i = 0; i < ch.length; i++) {
                if(history.contains(i)) continue;
                if(i == 0) {
                    lastIndex = 0;
                    continue;
                }

                if(ch[lastIndex] == ch[i]) {
                    needCheck = true;
                    history.add(lastIndex);
                    history.add(i);
                }
                lastIndex = i;
            }
        }
        return 0;
    }
}


public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("baabaa"));
        System.out.println(solution.solution("cdcd"));
    }
}
