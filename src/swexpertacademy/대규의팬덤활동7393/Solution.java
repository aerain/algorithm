package swexpertacademy.대규의팬덤활동7393;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

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

    private static long solution(int cases) {
        if (cases <= 9) return 0;
        if (cases == 10) return 1;
//        long n = (long) Math.pow(2, cases - 10);
        long answer = 1;
        for(int i = 1; i <= cases - 10; i++) {
            long n = (long) Math.pow(2, i);
            answer = ((n * n) - answer) % 1000000000;
        }
        return answer;
    }

        /*
        1
        2 * 2 - 1
        4 * 4 - 2
        8 * 8 - 4

        n * n - (n/2)
        즉 n * (n - 0.5) + 1
         */
        // 2 - 4 - 16 - 64 - 4096...?
        // 10일때 9876543210 1 -> 2 - 1
        // 11일때 98765432101, 89876543210, 10123456789, 3 4 - 1, 다음은 8 - 1 = 7 or 8 - 3 = 5 예상.
        // 12일때 789876543210, 989876543210, 987876543210, 987656543210, 987656543210, 987654543210, 987654343210, 987654323210, 987654321210, 987654321010, 987654321012, 987654321010
}
