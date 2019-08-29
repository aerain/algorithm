package swexpertacademy.방향전환8382;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            bw.write("#" + t + " " + solution(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())) + "\n");
        }
        br.close();
        bw.close();
    }

    private static int solution(int a, int b, int c, int d) {
        int answer = 0;

        int x = Math.abs(c - a);
        int y = Math.abs(b - d);

        if(x == y) return x * 2;
        //정사각형으로 대각질주한다음에 일자질주하는게 젤 빠르지 않을까?
        //x를 무조건 크게. 즉 가로가 긴 직사각형으로 만듬.
        if(x < y) {
            int temp = x;
            x = y;
            y = temp;
        }
        answer += (y * 2);
        x -= y;
        answer += isOdd(x) ? (x - 1) * 2 + 1 : x * 2;
        return answer;
    }
    private static boolean isOdd(int i) { return i % 2 == 1; }
}
