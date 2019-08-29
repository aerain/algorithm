package swexpertacademy.한솔택배알바7333;

import java.io.*;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        int N;
        int[] boxes;
        for(int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            boxes = new int[N];
            for(int n = 0; n < N; n++) boxes[n] = Integer.parseInt(br.readLine());
            bw.write("#" + t + " " + solution(boxes) + "\n");
        }
        br.close();
        bw.close();
    }

    private static int solution(int[] boxes) {
        Arrays.sort(boxes);
        int l = 0, r = boxes.length - 1;
        int answer = 0;
        int count, heavy;
        while(l <= r) {
            if(boxes[r] >= 50) { // 가장무거운거 하나만 들어도 오케이일때!
                answer++;
                r--;
                continue;
            }
            if(l == r) break;
            count = 2; // 박스는 기본 두개 잡고 시작하니까
            heavy = boxes[r];
            while(heavy * count < 50) {
               if(l == r) break;
                count++;
                l++;
            }
            if(l < r) answer++;
            l++;
            r--;
        }
        return answer;
    }
}
