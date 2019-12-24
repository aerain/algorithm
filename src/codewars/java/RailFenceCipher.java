package codewars.java;

import java.util.*;

public class RailFenceCipher {
    static String encode(String s, int n) {
        // Your code here
        boolean reverse = false;
        int pos = 1;
        char[] ch = s.toCharArray();

        Map<Integer, StringBuilder> map = new HashMap<>();
        for(int i = 1; i <= n; i++) map.put(i, new StringBuilder());

        for(int i = 0; i < ch.length; i++) {
            map.get(pos).append(ch[i]);
            if(pos == 1) reverse = false;
            if(pos == n) reverse = true;
            pos = reverse ? pos - 1 : pos + 1;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) sb.append(map.get(i));
        return sb.toString();
    }

    static String decode(String s, int n) {
        // Your code here
        int[] lengths = new int[n];
        int pos = 0;
        boolean reverse = false;
        for(int i = 0; i < s.length(); i++) {
            lengths[pos]++;
            if(pos == 0) reverse = false;
            if(pos == n - 1) reverse = true;
            pos = reverse ? pos - 1 : pos + 1;
        }

        Map<Integer, char[]> map = new HashMap<>();

        int startPos = 0;
        for(int i = 0; i < n; i++) {
            map.put(i, s.substring(startPos, startPos + lengths[i]).toCharArray());
            startPos += lengths[i];
        }

        reverse = false;
        pos = 0;
        int[] posarr = new int[n];

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            sb.append(map.get(pos)[posarr[pos]++]);
            if(pos == 0) reverse = false;
            if(pos == n - 1) reverse = true;
            pos = reverse ? pos - 1 : pos + 1;
        }
        return sb.toString();
    }
}
