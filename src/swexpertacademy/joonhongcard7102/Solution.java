package swexpertacademy.joonhongcard7102;

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
            bw.write("#" + t + " " + solution(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())) + "\n");
        }
        br.close();
        bw.close();
    }

    private static String solution(int N, int M) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int n = 1; n <= N; n++) {
            for(int m = 1; m <= M; m++) {
                if(!map.containsKey(m + n)) map.put(m + n, 1);
                else map.put(m + n, map.get(m + n) + 1);
            }
        }

        int max = Integer.MIN_VALUE;
        for(int item : map.values()) max = Math.max(max, item);

        List<String> list = new ArrayList<>();

        Iterator<Integer> it = map.keySet().iterator();
        while(it.hasNext()) {
            Integer next = it.next();
            if(map.get(next).equals(max)) {
                list.add(Integer.toString(next));
            }
        }
        return String.join(" ", list);
    }
}
