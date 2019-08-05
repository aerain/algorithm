package swexpertacademy.sujeong8050;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        int N, K;

        for(int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            bw.write("#" + t + " " + String.join(" ", solution()) + "\n");
        }
        br.close();
        bw.close();
    }

    public static String[] solution () {
        int length  = 0;
        int caseNum = 0;




        return new String[] {
            String.valueOf(length),
            String.valueOf(caseNum)
        };
    }
}
