package swexpertacademy.noglasses7272;

import java.io.*;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class Solution {
    static Pattern[] patterns = new Pattern[] {
            Pattern.compile("[CEFGHIJKLMNSTUVWXYZ]"),
            Pattern.compile("[ADOPQR]"),
            Pattern.compile("B")
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            bw.write("#" + t + " " + solution(st.nextToken(), st.nextToken()) + "\n");
        }
        br.close();
        bw.close();
    }

    private static String solution(String prev, String next) {
        if(prev.length() != next.length()) return "DIFF";
        for(int i = 0; i < patterns.length; i++) {
            prev = patterns[i].matcher(prev).replaceAll(String.valueOf(i));
            next = patterns[i].matcher(next).replaceAll(String.valueOf(i));
        }
        if(prev.equals(next)) return "SAME";
        return "DIFF";
    }
}
