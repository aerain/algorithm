package programmers.섬연결하기;

import java.util.Arrays;

public class Solution {
    public int getParent(int[] set, int x) {
        if(set[x] == x) return x;
        return set[x] = getParent(set, set[x]);
    }

    public void unionParent(int set[], int a, int b) {
        a = getParent(set, a);
        b = getParent(set, b);
        if(a < b) set[b] = a;
        else set[a] = b;
    }

    public boolean find(int[] set, int a, int b) {
        a = getParent(set, a);
        b = getParent(set, b);
        return a == b;
    }
    public int solution(int n, int[][] costs) {
        int[] set = new int[n];
        for(int i = 0; i < n; i++) set[i] = i;
        return Arrays.stream(costs)
                .map(cost -> new Bridge(cost[0], cost[1], cost[2]))
                .sorted()
                .mapToInt(bridge -> {
                    if(!find(set, bridge.a, bridge.b)) {
                        unionParent(set, bridge.a, bridge.b);
                        return bridge.cost;
                    }
                    return 0;
                }).sum();
    }
}
class Bridge implements Comparable<Bridge> {
    int a, b, cost;
    public Bridge(int a, int b, int cost) {
        this.a = a;
        this.b = b;
        this.cost = cost;
    }
    @Override
    public int compareTo(Bridge o) {
        return Integer.compare(this.cost, o.cost);
    }
}
