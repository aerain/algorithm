package swexpertacademy.터널속의기차5357;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int N, H;
        StringTokenizer st;
        int[] cars;
        int[] lights;
        for(int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            cars = new int[N];
            lights = new int[N];
            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < N; i++) cars[i] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < N; i++) lights[i] = Integer.parseInt(st.nextToken());

            bw.write("#" + t + " " + solution(H, cars, lights) + "\n");
        }
        br.close();
        bw.close();
    }

    private static int solution(int tunnel_length, int[] cars, int[] lights) {
        int answer = 0;

        return 0;
    }
}
