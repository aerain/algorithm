package swexpertacademy.SEM7532;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int S, E, M;
        for(int idx = 1; idx <= T; idx++) {
            String[] line = br.readLine().split(" ");
            S = Integer.parseInt(line[0]);
            E = Integer.parseInt(line[1]);
            M = Integer.parseInt(line[2]);

            bw.write("#" + idx + " " + solution(S, E, M) + "\n");
        }

        br.close();
        bw.close();
    }

    private static int solution(int S, int E, int M) {
        int year = 1;
        int s = 1;
        int e = 1;
        int m = 1;
        while(!(s == S && e == E && m == M)) {
            s++;
            e++;
            m++;
            if(s > 365) s = 1;
            if(e > 24) e = 1;
            if(m > 29) m = 1;
            year++;
        }
        return year;
    }
}
