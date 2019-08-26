package swexpertacademy.햄스터8275;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    StringTokenizer st;
    public static int[] solution(int N, int X, int M, int[][] cases) {
        String answer;
        int l, r, s;
        for(int m = 0; m < M; m++) {
            l = cases[m][0]; r = cases[m][1]; s = cases[m][2];

        }

        return new int[] { 0, 1, 2};
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int N, X, M;
        int[][] cases;
        for(int i = 1; i <= T; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken()); X = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
            cases = new int[M][];
            for(int m = 0; m < M; m++) {
                st = new StringTokenizer(br.readLine(), " ");
                cases[m] = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            }
            bw.write("#" + i + " " + String.join(" ", Arrays.stream(solution(N, X, M, cases)).mapToObj(String::valueOf).toArray(String[]::new)));
        }
        br.close();
        bw.close();
    }
}
