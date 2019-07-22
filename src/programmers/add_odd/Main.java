package programmers.add_odd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int length = Integer.parseInt(br.readLine());
        int sum = 0;
        for(int i = 1; i <= length; i++) {
            sum = Arrays.stream(br.readLine().split(" "))
                    .map(Integer::parseInt)
                    .filter(integer -> integer % 2 == 1)
                    .reduce(0, Integer::sum);
            sb.append("#" + i + " " + sum + "\n");
        }
        System.out.println(sb.toString());
    }
}