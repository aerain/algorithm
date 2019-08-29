package swexpertacademy.현규의연봉계산법7338;

import java.io.*;

public class Solution {
    public static long base = 2016;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] tc;
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            tc = br.readLine().split(" ");
            bw.write("#" + t + " " + solution(Long.parseLong(tc[0]), Long.parseLong(tc[1])) + "\n");
        }
        br.close();
        bw.close();
    }

    private static String solution(long year, long month) {
        long dyear = year - base;
        month += dyear * 12;
        long convertedmonth = month % 13;
        long convertedyear = month / 13;
        if(convertedmonth == 0) {
            convertedyear--;
            convertedmonth = 13;
        }
        return (base + convertedyear) + " " + convertedmonth;
    }
}
