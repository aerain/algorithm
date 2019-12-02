package swexpertacademy.평균값구하기2071;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            int[] arr = new int[10];
            for(int i = 0; i < arr.length; i++) arr[i] = Integer.parseInt(st.nextToken());
            bw.write("#" + t + " " + solution(arr) + "\n");
        }
        bw.close();
        br.close();
    }

    private static int solution(int[] arr) {
        return (int) Math.round(Arrays.stream(arr).average().orElse(0));
    }
}
