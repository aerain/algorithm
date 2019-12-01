package codewars;

import java.util.HashMap;
import java.util.Map;

public class Greed {
    public static int greedy(int[] dice){
        //code here
        Map<Integer, Integer> count = new HashMap<>();
        int sum = 0;
        for(int digit: dice) {
            count.put(digit, count.getOrDefault(digit, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry: count.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if(value / 3 > 0) {
                switch(key) {
                    case 1: sum += 1000; break;
                    case 6: sum += 600; break;
                    case 5: sum += 500; break;
                    case 4: sum += 400; break;
                    case 3: sum += 300; break;
                    case 2: sum += 200; break;
                }
                value %= 3;
            }
            switch(key) {
                case 1: sum += 100 * value; break;
                case 5: sum += 50 * value; break;
            }
        }
        return sum;
    }
}
