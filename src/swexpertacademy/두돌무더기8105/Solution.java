package swexpertacademy.두돌무더기8105;

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
            bw.write("#" + t + " " + solution(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())) + "\n");
        }

        br.close();
        bw.close();
    }

    private static String solution(int a, int b) {
        if(a > b) {
            int temp = a;
            a = b;
            b = temp;
        }
        if(a % 2 == 1 && b % 2 == 1) return "B";
        if(a % 2 == 0 && b % 2 == 0) return "A";
        if(a == 1 && b % 2 == 1) return "A";
        if(a % 2 == 0 && b % 2 == 1) return "A";
        return null;
    }
}
