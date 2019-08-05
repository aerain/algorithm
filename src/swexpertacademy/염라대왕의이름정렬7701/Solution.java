package swexpertacademy.염라대왕의이름정렬7701;

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        int N;
        for(int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            Set<String> names = new TreeSet<>((o1, o2) -> {
                if(o1.length() < o2.length()) return -1;
                else if(o1.length() > o2.length()) return 1;
                else return o1.compareTo(o2);
            });
            for(int i = 0; i < N; i++) names.add(br.readLine());
            bw.write("#" + t + "\n");
            for (String name : names) bw.write(name + "\n");
        }
        br.close();
        bw.close();
    }
}
