package programmers.apio13.toll;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // N은 마을 수, M은 양방향 도로의 수, K는 새로운 도로의 개수.
        // 그리디 아저씨는 K개의 도로로 수익을 최대화 하려고하낟.
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Map<Integer, Town> spanningTree = new HashMap<>();

        for(int n = 1; n <= N; n++) spanningTree.put(n, new Town());

        int a, b, c;
        for(int m = 1; m <= M; m++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());




        }

        br.close();
        bw.close();
    }
}

class Town {
    Town prev;
    Town next;
}
