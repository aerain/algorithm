package programmers.bridge_truck;

public class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int[] bridge = new int[bridge_length];
        int time = 0;
        int truck_index = 0;
        int current_weights = 0;
        int stack = 0;
        while(truck_index < truck_weights.length) {
            // 0 이상일 때
            if(current_weights > 0) {

                // 현재를 다리를 담을 수 없으면 한 트럭을 내보내라
                if(current_weights + truck_weights[truck_index] > weight) {
                    int jump = 1;
                    while(jump < bridge_length && bridge[jump] == 0) jump++;
                    current_weights -= bridge[bridge_length - jump];
                    time += jump;
                    for(int i = bridge_length - 1; i > jump; i--) bridge[i] = bridge[i - jump];
                }

                int willstart = bridge_length - 1;
                while(bridge[willstart] == 0) willstart--;

                for(int j = willstart + 1; j > 0; j++) {
                    if(j < bridge_length) bridge[j] = bridge[j - 1];
                }
            }
            for(int i = bridge_length - 1; i > 0; i--) {
                bridge[i] = bridge[i - 1];
            }
            bridge[0] = truck_weights[truck_index++];
            time++;
            stack++;
            current_weights += bridge[0];
        }

        return time + bridge_length;
    }
}
