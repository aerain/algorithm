package swexpertacademy.bomb8049;

// 문제를 이해를 못했다.

import java.io.*;
import java.util.regex.Pattern;

public class Solution {
    static final Pattern[] patterns;
    static {
        patterns = new Pattern[] {
                Pattern.compile("F(C+)MF"),
                Pattern.compile("F(F+)MC(M+)")
        };
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++) {
            bw.write("#" + t + " " + solution(br.readLine()) + "\n");
        }

        br.close();
        bw.close();
    }

    private static String solution(String s) {
        boolean answer = false;
        for(Pattern pattern : patterns) {
            s = pattern.matcher(s).replaceAll("");
        }
        return s.length() == 0 ? "DETECTED!" : "NOTHING!";
    }
}
