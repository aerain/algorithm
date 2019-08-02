package swexpertacademy.verydivisor7854;

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) bw.write("#" + t + " " + solution(Integer.parseInt(br.readLine())) + "\n");
        br.close();
        bw.close();
    }

    private static int solution(int X) {
        Set<Integer> veryDivisorSet = new HashSet<>();
        Queue<Value> queue = new LinkedList<>();
        queue.offer(new Value(0, 0));

        Value poll = null;
        while(!queue.isEmpty()) {
            poll = queue.poll();
            veryDivisorSet.add(poll.value);

            if(poll.isTwoOk(X)) queue.offer(new Value(poll.two + 1, poll.five));
            if(poll.isFiveOk(X)) queue.offer(new Value(poll.two, poll.five + 1));
        }
        return veryDivisorSet.size();
    }
}

class Value {
    int two, five, value;
    Value(int two, int five) {
        this.two = two;
        this.five = five;
        this.value = (int) (Math.pow(2, two) * Math.pow(5, five));
    }

    boolean isTwoOk(int X) {
        return two <= five && (long) value * 2 <= X;
    }

    boolean isFiveOk(int X) {
        return five - two < 3 && (long) value * 5 <= X;
    }
}
