package swexpertacademy.오나의여신님7793;

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int N, M;
        char[][] maps;
        StringTokenizer st;
        for(int t = 1; t<=T; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            maps = new char[N][];
            for(int n = 0; n < N; n++) maps[n] = br.readLine().toCharArray();
            int answer = solution(N, M, maps);
            bw.write("#" + t + " " + (answer == -1 ? "GAME OVER" : answer) + "\n");
        }
        br.close();
        bw.close();
    }

    private static int solution(int n, int m, char[][] maps) {
        List<char[][]> timestamps = new ArrayList<>();
        Queue<char[][]> queue = new LinkedList<>();
        queue.offer(maps);
        while(!queue.offer(maps)) {
        }
        return 0;
    }
}
