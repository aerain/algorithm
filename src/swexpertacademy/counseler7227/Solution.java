package swexpertacademy.counseler7227;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        int N;
        int[][] coords;
        for(int t = 0; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            coords = new int[N][];
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                coords[i] = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            }
            bw.write("#" + t + " " + solution(N, coords) + "\n");
        }

        br.close();
        bw.close();
    }

    private static int solution(int n, int[][] coords) {
        int answer = 0;
        
        return answer;
    }
}
