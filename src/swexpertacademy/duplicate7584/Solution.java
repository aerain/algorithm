package swexpertacademy.duplicate7584;

import java.io.*;

public class Solution {

    static long end = 1L << 60; // 10^18보다 큰 숫자.

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

    private static int solution(long K) {
        int answer = 0;
        long l = 1;
        long r = end; // 10^18 보다 큰 숫자.

        while(l <= r) {
            long mid = (l + r) / 2;
            if(K < mid) {
                r = mid - 1;
                answer = 0;
            } else if(K > mid) {
                l = mid + 1;
                answer = 1;
            } else {
                break;
            }
        }
        return answer;
    }
}
