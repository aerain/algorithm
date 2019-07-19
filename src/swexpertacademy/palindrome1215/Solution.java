package swexpertacademy.palindrome1215;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = 10;
        char[][] arr;
        int n, len;
        for(int t = 1; t <= T; t++) {
            n = Integer.parseInt(br.readLine());
            char[] head = br.readLine().toCharArray();
            len = head.length;
            arr = new char[len][];
            arr[0] = head;
            for (int i = 1; i < len; i++) arr[i] = br.readLine().toCharArray();
            bw.write("#" + t + " " + solution(n, arr) + "\n");
        }
        br.close();
        bw.close();
    }

    private static int solution(int n, char[][] arr) {
        int answer = 0;
        char[] copied = new char[n];
        // 가로 탐색
        for(int i = 0; i <= arr.length - n; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                for(int k = 0; k < n; k++) copied[k] = arr[i + k][j];
                if(isPalinDrome(copied)) answer++;
            }
        }

        // 세로 탐색
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j <= arr[i].length - n; j++) {
                for(int k = 0; k < n; k++) copied[k] = arr[i][j + k];
                if(isPalinDrome(copied)) answer++;
            }
        }
        return answer;
    }

    private static boolean isPalinDrome(char[] copied) {
        int n = copied.length;
        for(int i = 0; i < n; i++) {
            if(copied[i] != copied[n - i - 1]) return false;
        }
        return true;
    }
}
