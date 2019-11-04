package swexpertacademy.큐브색칠3812;

import java.io.*;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.LongStream;
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb;
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            long[] answer = solution(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()));
            sb = new StringBuilder();
            for(long ans: answer) sb.append(" ").append(ans);
            bw.write("#" + t + sb + "\n");
        }
        br.close();
        bw.close();
    }

    private static long[] solution(int x, int y, int z, int a, int b, int c, int n) {
        long[] arr = new long[n];
        // 1
        // 1 2 1
        // 1 4 6 4 1 4C0 + 4C1 + 4C2 + 4C3 + 4C4
        // 1 5 10 10 5 1
        // 1 6 15 20 15 6

        // 하나씩 늘려가

        return arr;
    }

    // 1~10 1개
    // 10~99 14, 24, 34, 44, 54, 64, 74, 84, 94, 40, 41, 42, 43, 45, 46, 47, 48, 49 => 18개
    // 1 + 1 + 1 + 1 + 10 + 1 + 1 + 1 + 1
    // 1~99는 19개
    // 1~999개는
}
