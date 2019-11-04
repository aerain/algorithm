package programmers.bridge_truck;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < bridge_length; i++) queue.offer(0);
        int index = 0;

        // initial
        int totalWeight = truck_weights[index++];
        int time = 1;
        queue.offer(totalWeight);
        queue.poll();

        while(index < truck_weights.length) {
            while(totalWeight + truck_weights[index] > weight) {
                while(queue.peek() == 0) {
                    queue.offer(0);
                    queue.poll();
                    time++;
                    System.out.println(queue);
                }
                queue.offer(0);
                totalWeight -= queue.poll();
                time++;
            }
            while(index < truck_weights.length && totalWeight + truck_weights[index] <= weight) {
                int truck = truck_weights[index++];
                queue.offer(truck);
                totalWeight += truck;
                queue.poll();
                time++;
                System.out.println(queue);
            }
        }

        int i = 1;
        int j = i;
        while(!queue.isEmpty()) {
            int poll = queue.poll();
            if(poll != 0) j = i;
            i++;
        }

        time+=j;


        return time;
    }
}

class Truck {
    int weight;
    public Truck(int weight) {
        this.weight = weight;
    }
    @Override
    public String toString() {
        return String.valueOf(this.weight);
    }
}
