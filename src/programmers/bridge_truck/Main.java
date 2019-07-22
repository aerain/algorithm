package programmers.bridge_truck;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int index = 0;

        int onBridgeWeight = 0;
        int onBridgeCount = 0;
        int headIndex = -1;
        while(index < truck_weights.length) {
            System.out.println(answer + ", " + onBridgeCount + ", " + onBridgeWeight);
            if(onBridgeWeight + truck_weights[index] <= weight || onBridgeCount < bridge_length) {
                onBridgeWeight += truck_weights[index++];

                answer++;
                onBridgeCount++;
            } else {
                answer += (bridge_length - onBridgeCount + 1);
                onBridgeWeight -= truck_weights[index - onBridgeCount--];
            }
        }
        if(onBridgeWeight != 0)
            answer += bridge_length;

        System.out.println(answer);
        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int a = solution.solution(2, 10, new int[] {7, 4, 5, 6});
        int b = solution.solution(100, 100, new int[] {10});
        int c = solution.solution(100, 100, new int[] {10, 10, 10, 10, 10, 10, 10, 10, 10, 10});
        int d = solution.solution(2, 11, new int[] {1, 2, 8, 10});
        int e = solution.solution(2, 10, new int[] {4, 6, 3, 7});

        if(a == 8) System.out.println("a correct");
        if(b == 101) System.out.println("b correct");
        if(c == 110) System.out.println("c correct");
        if(d == 6) System.out.println("d correct");
        if(e == 6) System.out.println("e correct");
    }
}
