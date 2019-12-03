package codewars.java;

import java.util.Arrays;

public class Scramblies {
    public static boolean scramble(String str1, String str2) {
        if(str1.length() < str2.length()) return false;

        char[] str1ch = str1.toCharArray();
        char[] str2ch = str2.toCharArray();
        Arrays.sort(str1ch);
        Arrays.sort(str2ch);

        int matchCount = 0;
        int i = 0, j = 0;
        while(i < str1ch.length && j < str2ch.length) {
            if(str1ch[i] < str2ch[j]) {
                i++;
            } else if(str1ch[i] > str2ch[j]) {
                j++;
            } else {
                matchCount++;
                i++;
                j++;
            }
        }
        return matchCount == str2.length();
    }
}
