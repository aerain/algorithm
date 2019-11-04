package swexpertacademy.제곱근놀이6782;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            bw.write("#" + t + " " + solution(Long.parseLong(br.readLine())) + "\n");
        }
        br.close();
        bw.close();
    }

    private static long solution(long n) {
        if(n == 2) return 0;
        long answer = 0;
        while(n > 2) {
            long find = (long) Math.pow((long) Math.ceil(Math.sqrt(n)), 2);
            answer += find - n;
            n = (long) Math.sqrt(find);
            answer++;
        }
        return answer;
    }
}
