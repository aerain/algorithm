package programmers.fourmaester;

import java.util.*;

class Solution {
    public int solution(String arr[]) {
        int answer = Integer.MIN_VALUE;
        int[] list = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            if(arr[i].equals("-")) list[i] = 1001;
            else if(arr[i].equals("+")) list[i] = 1002;
            else list[i] = Integer.parseInt(arr[i]);
        }


        int temp, offset;
        int[] temparr;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(list);
        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            for(int i = 0; i < poll.length - 1; i += 2) {
                temp = poll[i + 1] == 1001 ? poll[i] - poll[i+ 2] : poll[i] + poll[i + 2];
                temparr = new int[poll.length - 2];
                offset = 0;
                for(int j = 0; j < poll.length; j++) {
                    if(j == i + 1 || j == i + 2) {
                        offset++;
                    } else if( j == i) {
                        temparr[j] = temp;
                    } else {
                        temparr[j - offset] = poll[j];
                    }
                }
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

