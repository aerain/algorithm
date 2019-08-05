package swexpertacademy.팩토리얼7466;

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            bw.write("#" + t + " " + gcd(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())) + "\n");
        }

        br.close();
        bw.close();
    }

    private static long gcd(long n, long k) {
        List<Integer> yaksu = new ArrayList<>();
        // 약수 찾기
        for(int i = 1; i <= k / 2 + 1; i++) {
            if(k % i == 0) yaksu.add(i);
        }
        yaksu.add((int) k);
        int answer = 0;
        long count = 1;
        // 최대 찾기
        for(int i = (int) n; i >= 1; i--) {
            count *= i;
            if(count % k == 0) return k;
            if(yaksu.contains(i)) answer = Math.max(answer, i);
//            if(count >= k) break;
        }
        return answer;
    }
}
