package swexpertacademy.permdivide38568;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int N;
        int[] P;
        for(int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            P = new int[N];
            for(int i = 0; i < N; i++) P[i] = Integer.parseInt(st.nextToken());
            bw.write("#" + t + " " + solution(N, P) + "\n");
        }
        br.close();
        bw.close();
    }

    public static int solution(int N, int[] P) {
        int onetwo = 0, onezero = 0, twozero = 0;
        int answer = 0;
        int pos = 0;
        for(int p: P) {
            p %= 3;
            if(pos != p) {
                if(pos == 1 && p == 2) {
                    onetwo++;
                } else if(pos == 1 && p == 0) {
                    onezero++;
                } else if(pos == 2 && p == 0) {
                    twozero++;
                }
            }
            pos++;
            if(pos == 3) pos = 0;
        }
        System.out.println(onetwo + ", " + onezero + ", " + twozero);
        return answer;
    }
}
