package heap.diskcontroller;

import java.util.*;

public class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int pc = 0;
        Arrays.sort(jobs, Comparator.comparingInt(o -> o[0]));
        Queue<int[]> time = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        Arrays.stream(jobs).forEach(time::offer);
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

        queue.offer(time.poll());
        while(!time.isEmpty() && queue.peek()[0] == time.peek()[0]) queue.offer(time.poll());

        while(!queue.isEmpty() || !time.isEmpty()) {
            int[] onProgress = queue.poll();
            if(pc < onProgress[0]) {
                int abs = onProgress[0] - pc;
                pc += abs;
            }

            while(!time.isEmpty() && time.peek()[0] < pc + onProgress[1]) {
                queue.offer(time.poll());
            }

            answer += pc - onProgress[0] + onProgress[1];
            pc += onProgress[1];

            System.out.println(answer);

            if(queue.isEmpty() && !time.isEmpty()) {
                queue.offer(time.poll());
                while(!time.isEmpty() && queue.peek()[0] == time.peek()[0]) queue.offer(time.poll());
            }
        }
        System.out.println(answer / jobs.length + "가 정답");
        return answer / jobs.length;
    }
}
