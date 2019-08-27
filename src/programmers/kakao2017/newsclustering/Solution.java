package programmers.kakao2017.newsclustering;

import java.util.*;

public class Solution {
    public int solution(String str1, String str2) {
        return (int) (J(makeMultiSet(str1), makeMultiSet(str2)) * 65536);
    }

    double J(Map<String, Integer> str1, Map<String, Integer> str2) {
        Set<String> keys = new HashSet<>(str1.keySet());
        keys.addAll(str2.keySet());
        if(str1.size() == 0 && str2.size() == 0) return 1; // divide by zero
        int gyo = 0, hap = 0, s1, s2;
        for(String key: keys) {
            s1 = str1.getOrDefault(key, 0);
            s2 = str2.getOrDefault(key, 0);
            gyo += Math.min(s1, s2);
            hap += Math.max(s1, s2);
        }
        return (double) gyo / (double) hap;
    }

    Map<String, Integer> makeMultiSet(String str) {
        Map<String, Integer> map = new HashMap<>();
        char[] ch = str.toLowerCase().toCharArray();
        char ch1, ch2;
        for(int i = 0; i < ch.length - 1; i++) {
            ch1 = ch[i]; ch2 = ch[i + 1];
            if(isAlphabet(ch1) && isAlphabet(ch2)) {
                String s = String.valueOf(ch1) + ch2;
                if(map.containsKey(s)) {
                    map.put(s, map.get(s) + 1);
                } else {
                    map.put(s, 1);
                }
            }
        }
        return map;
    }
    boolean isAlphabet(char ch) {
        return ch >= 'a' && ch <= 'z';
    }
}
