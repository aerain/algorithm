package swexpertacademy.만화책정렬하기8191;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int N;
        int[] numbers;
        StringTokenizer st;
        for(int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            numbers = new int[N];
            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < N; i++) numbers[i] = Integer.parseInt(st.nextToken());
            bw.write("#" + t + " " + solution(numbers) + "\n");
        }

        br.close();
        bw.close();
    }

    private static int solution(int[] numbers) {
        int min = Integer.MAX_VALUE;
        int answer = 0;
        for(int number: numbers) {
            if(number < min) {
                answer++;
                min = number;
            }
        }
        return answer;
    }
}
