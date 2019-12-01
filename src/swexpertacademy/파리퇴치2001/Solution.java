package swexpertacademy.파리퇴치2001;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int[][] arr = new int[M][];
            for(int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                arr[i] = new int[M];
                for(int j = 0; j < M; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            bw.write("#" + t + " " + solution(arr, M, N) + "\n");
        }
        bw.close();
        br.close();
    }

    private static int solution(int[][] arr, int m, int n) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i <= m - n; i++) {
            for(int j = 0; j <= m - n; j++) {
                max = Math.max(max, find(arr, n, i, j));
            }
        }
        return max;
    }
    private static int find(int[][] arr, int n, int startx, int starty) {
        int sum = 0;
        for(int i = startx; i < startx + n; i++) {
            for(int j = starty; j < starty + n; j++) {
                sum += arr[i][j];
            }
        }
        return sum;
    }
}
