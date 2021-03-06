package programmers.kakao2018a.prizehunter;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            bw.write(solution(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())) + "\n");
        }

        br.close();
        bw.close();
    }

    private static int solution(int a, int b) {
        int aPrize, bPrize;
        if(a == 1) aPrize = 5000000;
        else if(a >= 2 && a <= 3) aPrize = 3000000;
        else if(a >= 4 && a <= 6) aPrize = 2000000;
        else if(a >= 7 && a <= 10) aPrize = 500000;
        else if(a >= 11 && a <= 15) aPrize = 300000;
        else if(a >= 16 && a <= 21) aPrize = 100000;
        else aPrize = 0;

        if(b == 1) bPrize = 5120000;
        else if(b >= 2 && b <= 3) bPrize = 2560000;
        else if(b >= 4 && b <= 7) bPrize = 1280000;
        else if(b >= 8 && b <= 15) bPrize = 640000;
        else if(b >= 16 && b <= 31) bPrize = 320000;
        else bPrize = 0;
        return aPrize + bPrize;
    }
}
