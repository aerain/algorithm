package swexpertacademy.quiz7965;

import java.io.*;

public class Solution {
    static final long MOD = 1000000007L;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) bw.write("#" + t + " " + solution(Integer.parseInt(br.readLine())) + "\n");
        br.close();
        bw.close();
    }

    private static long solution(int n) {
        long answer = 0;
        for(int i = 1; i <= n; i++) {
            answer += Math.pow(i, i);
        }
        System.out.println(answer % MOD);
        return answer;
    }
}
