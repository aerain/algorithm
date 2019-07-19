package swexpertacademy.sangwon7510;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++) {
            bw.write("#" + t + " " + solution(Integer.parseInt(br.readLine())) + "\n");
        }

        br.close();
        bw.close();
    }

    private static int solution(int n) {
        int answer = 0;
        for(int i = 1; i < n / 2 + 1; i++) {
            if(n % i == 0 && i % 2 != 0)
                answer++;
        }
        return answer;
    }
}
