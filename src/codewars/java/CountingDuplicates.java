package codewars.java;

import java.util.*;

public class CountingDuplicates {
    public static int duplicateCount(String text) {
        Set<Character> set = new HashSet<>();
        List<Character> list = new ArrayList<>();
        for(char ch: text.toLowerCase().toCharArray()) {
            if(set.contains(ch)) {
                if(!list.contains(ch)) {
                    list.add(ch);
                }
            } else {
                set.add(ch);
            }
        }
        return list.size();
    }
}
