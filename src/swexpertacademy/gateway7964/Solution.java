package swexpertacademy.gateway7964;

import java.io.*;

public class Solution {
    private static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int N, D;
        String[] nd, gateway;
        for(int idx = 1; idx <= T; idx++) {
            sb.append('#').append(idx).append(' ');
            nd = br.readLine().split(" ");
            N = Integer.parseInt(nd[0]);
            D = Integer.parseInt(nd[1]);
            gateway = br.readLine().split(" ");
            solution(N, D, gateway);
            sb.append('\n');
        }

        System.out.println(sb.toString().trim());
    }

    private static void solution(int n, int d, String[] gateway) {
        int answer = 0;
        int stack = 0;
        for(int i = 0; i < n; i++) {
            if(gateway[i].equals("1")) stack = 0;
            else stack++;

            if(stack == d) {
                answer ++;
                stack = 0;
            }
        }
        sb.append(answer);
    }
}
