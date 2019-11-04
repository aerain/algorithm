package swexpertacademy.북북서8556;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    static Pattern p = Pattern.compile("(north|west)");
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            bw.write("#" + t + " " + solution(br.readLine()) + "\n");
        }
        br.close();
        bw.close();
    }

    private static String solution(String s) {
        Matcher m = p.matcher(s);
        int a = 0;
        int b = 0;
        int i = 0;
        while(m.find()) {
            if(i < 1) {
                if(m.group().equals("north")) a = 0;
                else a = 90;
                b = 1;
                i++;
                continue;
            }

            a *= 2;
            b *= 2;

            if(m.group().equals("north")) {
                if(a > 0) a -= 90;
            } else {
                if(a < 90 * b) a += 90;
            }
        }
        return ((double) a) / ((double) b) == (a / b) ? String.valueOf(a / b) : (a / 2) + "/" + (b / 2);
    }
}
