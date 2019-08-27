package programmers.kakao2017.traffic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Solution {
    static SimpleDateFormat format;
    static {
        format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
    }
    public int solution(String[] lines) {
        PriorityQueue<Traffic> queue = new PriorityQueue<>(lines.length * 2, Traffic::compareTo);
        try {
            String[] split;
            long time;
            int duration;
            for(String line : lines) {
                split = line.split(" ");
                time = format.parse(split[0] + " " + split[1]).getTime();
                duration = (int) (Double.parseDouble(split[2].substring(0, split[2].length() - 1)) * 1000) - 1;
                queue.offer(new Traffic(time - duration, true));
                queue.offer(new Traffic(time - 1, false));
            }
        } catch (ParseException ignored) {}

        Queue<Traffic> window = new LinkedList<>();
        int max = Integer.MIN_VALUE;
        int stack =0;
        long startTime;
        Traffic poll;
        while(!queue.isEmpty()) {
            poll = queue.poll();
            startTime = poll.startTime - 1000;
            window.offer(poll);
            if(poll.isStart) stack++;
            while(!window.isEmpty() && window.peek().isStart) window.poll();
            while(!window.isEmpty() && !window.peek().isStart && window.peek().startTime < startTime) {
                window.poll();
                stack--;
            }
            max = Math.max(stack, max);
        }
        return max;
    }
}

class Traffic implements Comparable{
    Long startTime;
    boolean isStart;

    public Traffic(Long startTime, boolean isStart) {
        this.startTime = startTime;
        this.isStart = isStart;
    }

    @Override
    public int compareTo(Object o) {
        return this.startTime.compareTo(((Traffic) o).startTime);
    }

    @Override
    public String toString() {
        return startTime + ", " + isStart;
    }
}
