package swexpertacademy.timesense7732;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int idx = 1; idx <= T; idx++) {
            sb.append('#').append(idx).append(' ').append(solution(br.readLine(), br.readLine())).append('\n');
        }
        System.out.println(sb.toString().trim());
    }

    private static int getTime(String time) {
        String[] timearr = time.split(":");
        return IntStream
                .range(0, timearr.length)
                .mapToObj(index -> {
                    if(index == 0) return Integer.parseInt(timearr[index]) * 3600;
                    else if(index == 1) return Integer.parseInt(timearr[index]) * 60;
                    else return Integer.parseInt(timearr[index]);
                }).reduce(0, Integer::sum);
    }
    private static String solution(String start, String end) {
        int sec = getTime(end) - getTime(start);
        sec = sec >= 0 ? sec : sec + 86400;
        int hour = sec / 3600;
        sec %= 3600;
        int min = sec / 60;
        sec %= 60;
        return Arrays.stream(new int[] { hour, min, sec }).mapToObj(String::valueOf).map(value -> {
            if(value.length() == 1) return "0" + value;
            else return value;
        }).collect(Collectors.joining(":"));
    }
}
