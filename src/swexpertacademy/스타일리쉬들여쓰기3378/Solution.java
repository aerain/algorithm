package swexpertacademy.스타일리쉬들여쓰기3378;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    static Pattern sP = Pattern.compile("^[.]*");
    static Pattern[] patterns = new Pattern[] {
            Pattern.compile("\\("),
            Pattern.compile("\\)"),
            Pattern.compile("\\{"),
            Pattern.compile("\\}"),
            Pattern.compile("\\["),
            Pattern.compile("\\]"),
    };

    private static int[] solution(int p, int q, String[] masters, String[] yours) {
        int R = 0, C = 0, S = 0;
        int[] values = new int[6];

        for(String master : masters) {
            int[] ints = Arrays.stream(patterns).map(pattern -> pattern.matcher(master)).mapToInt(matcher -> {
                int answer = 0;
                while(matcher.find()) answer++;
                return answer;
            }).toArray();
            for(int i = 0; i < values.length; i++) {
                values[i] += ints[i];
            }
        }

        return new int[0];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int p, q;
        String[] master, you;
        StringTokenizer st;
        for(int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            p = Integer.parseInt(st.nextToken()); q = Integer.parseInt(st.nextToken());
            master = new String[p];
            you = new String[q];
            for(int i = 0; i < p; i++) master[i] = br.readLine();
            for(int i = 0; i < q; i++) you[i] = br.readLine();
            int[] answer = solution(p, q, master, you);
            StringBuilder sb = new StringBuilder();
            for(int ans : answer) sb.append(" ").append(ans);
            bw.write("#" + t + sb.toString() + "\n");
        }

        br.close();
        bw.close();
    }
}
