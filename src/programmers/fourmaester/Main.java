package programmers.fourmaester;

import java.util.*;
import java.util.stream.IntStream;

class Solution {
    public int solution(String arr[]) {
        int answer = Integer.MIN_VALUE;
        int[] list = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            if(arr[i].equals("-")) list[i] = 1001;
            else if(arr[i].equals("+")) list[i] = 1002;
            else list[i] = Integer.parseInt(arr[i]);
        }


        int temp;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(list);
        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            for(int i = 0; i < poll.length - 1; i += 2) {
                final int idx = i;
                temp = poll[idx + 1] == 1001 ? poll[idx] - poll[idx+ 2] : poll[idx] + poll[idx + 2];
                int[] temparr = IntStream.range(0, poll.length).filter(index -> index != idx + 1 && index != idx + 2).map(index -> poll[index]).toArray();
                temparr[idx] = temp;
                if(temparr.length == 1) {
                    answer = Math.max(answer, temparr[0]);
                } else {
                    queue.offer(temparr);
                }
            }
        }
        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new String[]{
                "1", "-", "3", "+", "5", "-", "8"
        }));
        System.out.println();
        System.out.println(solution.solution(new String[]{
                "5", "-", "3", "+", "1", "+", "2", "-", "4"
        }));
    }
}

