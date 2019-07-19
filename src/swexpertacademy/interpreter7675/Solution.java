package swexpertacademy.interpreter7675;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    static BufferedReader br;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int idx = 1; idx <= T; idx++) {
            sb.append('#').append(idx).append(' ');
            int n = Integer.parseInt(br.readLine());
            int[] answer = solution(n, splitStrings(n));
            for(int i = 0; i < answer.length; i++) {
                sb.append(answer[i]).append(i == answer.length - 1 ? '\n' : ' ');
            }
        }
        System.out.println(sb.toString().trim());
    }
    private static String[] splitStrings(int n) throws IOException {
        int temp = n;
        String line;
        StringBuilder sb = new StringBuilder();
        Pattern p = Pattern.compile("[?!.]");
        Matcher m;
        while(temp > 0) {
            line = br.readLine();
            m = p.matcher(line);
            while(m.find()) temp--;
            sb.append(line).append(' ');
        }
        return sb.toString().trim().split("[?!.]");
    }
    private static int[] solution(int n, String[] lines) {
        int[] answer = new int[n];
        Pattern p = Pattern.compile("^[A-Z][a-z]+$");
        for(int i = 0; i < n; i++) {
            String[] words = lines[i].trim().split(" ");
            answer[i] = (int) Arrays.stream(words).filter(word -> p.matcher(word).find()).count();
        }
        return answer;
    }
}
