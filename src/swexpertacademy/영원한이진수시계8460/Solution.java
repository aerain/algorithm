package swexpertacademy.영원한이진수시계8460;

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) bw.write("#" + t + " " + solution(br.readLine()) + "\n");
        br.close();
        bw.close();
    }

    private static String solution(String s) {
        Set<List<Integer>> stringSet = new HashSet<>();
        List<Integer> prev = makeArray(s);
        stringSet.add(prev);

        while(true) {
            List<Integer> value = new ArrayList<>(prev);
            for(int i = 0; i < value.size(); i++) {
                if(prev.get(i) == 1) {
                    if(i < value.size() - 1) value.set(i + 1, 1);
                    if(i > 0) value.set(i - 1, value.get(i - 1) == 1 ? 0 : 1);
                    value.set(i, 0);
                }
            }

            prev = value;

            boolean needContinue = false;
            for(int i : value) {
                if(i != 0) {
                    needContinue = true;
                    break;
                }
            }
            if(needContinue) {
                if(!stringSet.add(value)) return "LIVES";
            } else {
                return "DIES";
            }
        }
    }

    private static List<Integer> makeArray(String s) {
        List<Integer> value = new ArrayList<>();
        for(char ch: s.toCharArray()) {
            if(ch == '1') value.add(1);
            else value.add(0);
        }
        return value;
    }
}
