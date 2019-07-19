package swexpertacademy.legacy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Pattern p = Pattern.compile("[369]");
        Matcher m;
        String d;
        for(int i = 1; i <= n; i++){
            m = p.matcher(String.valueOf(i));
            d = "";
            while(m.find()) d += "-";
            sb.append(d.equals("") ? i : d).append(" ");
        }

        System.out.println(sb.toString());
    }
}
