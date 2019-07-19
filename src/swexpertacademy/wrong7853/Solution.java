package swexpertacademy.wrong7853;
import java.io.*;
import java.util.*;

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

    private static int solution(String string) {
        Set<String> stringSet = new TreeSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(string);

        char temp, temp2, temp3;
        char[] arr;
        String poll;
        String tempString;
        while (!queue.isEmpty()) {
            System.out.println(stringSet.size());
            poll = queue.poll();
            stringSet.add(poll);
            arr = poll.toCharArray();
            for(int i = 0; i < arr.length; i++) {
                temp = arr[i];
                if(i > 0) {
                    arr[i] = arr[i - 1];
                    tempString = new String(arr);
                    if(!stringSet.contains(tempString)) queue.offer(tempString);
                    arr[i] = temp;
                }
                if(i < arr.length - 1) {
                    arr[i] = arr[i + 1];
                    tempString = new String(arr);
                    if(!stringSet.contains(tempString)) queue.offer(tempString);
                    arr[i] = temp;
                }
                if(i > 0 && i < arr.length - 1) {
                    temp = arr[i - 1];
                    temp2 = arr[i + 1];
                    temp3 = arr[i];
                    arr[i - 1] = arr[i];
                    arr[i + 1] = arr[i];
                    arr[i] = temp;
                    tempString = new String(arr);
                    if(!stringSet.contains(tempString)) queue.offer(tempString);
                    arr[i] = temp2;
                    tempString = new String(arr);
                    if(!stringSet.contains(tempString)) queue.offer(tempString);
                    arr[i] = temp3;
                    arr[i - 1] = temp;
                    arr[i + 1] = temp2;
                }
            }
        }
        System.out.println(stringSet.toString());
        return stringSet.size();
    }
}

