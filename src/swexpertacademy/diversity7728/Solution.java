package swexpertacademy.diversity7728;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int idx = 1; idx <= T; idx++) {
            sb.append('#').append(idx).append(' ').append(solution(br.readLine())).append('\n');
        }
        System.out.println(sb.toString().trim());
    }

    private static int solution(String number) {
        Set<Character> diversity = new HashSet<>();
        char[] ch = number.toCharArray();
        for(int i = 0; i < ch.length; i++) {
            diversity.add(ch[i]);
        }
        return diversity.size();
    }
}
