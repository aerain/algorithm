package programmers.kakao2017.navigation;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int MOD = 20170805;
    int m, n;
    Way[][] ways;
    public int solution(int m, int n, int[][] cityMap) {
        long answer = 0;

        // 초기화
        this.m = m;
        this.n = n;

        ways = new Way[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                ways[i][j] = new Way(i, j,0, 0, cityMap[i][j]);
            }
        }

        Queue<Way> queue = new LinkedList<>();
        queue.offer(ways[0][0]);
        Way way;
        while(!queue.isEmpty()) {
            way = queue.poll();
            way.up = (way.x == 0 || ways[way.x - 1][way.y].status == 1) ? 0 : (ways[way.x - 1][way.y].status == 2 ? ways[way.x - 1][way.y].up : ways[way.x - 1][way.y].findAll());
            way.left = (way.y == 0 || ways[way.x][way.y - 1].status == 1) ? 0 : (ways[way.x][way.y - 1].status == 2 ? ways[way.x][way.y - 1].left : ways[way.x][way.y - 1].findAll());

            // 처음 한가지 경우 만들어줄려고 하드코딩.
            if(way.x == 0 && way.y == 0) way.left = 1;

            way.up %= MOD;
            way.left %= MOD;

            if(way.x < m - 1 && way.y == 0) queue.offer(ways[way.x + 1][way.y]);
            if(way.y < n - 1) queue.offer(ways[way.x][way.y + 1]);
        }
        return (int) (ways[m - 1][n - 1].findAll() % MOD);
    }
}

class Way {
    int x, y, status;
    long left, up;
    Way(int x, int y, long left, long up, int status) {
        this.x = x;
        this.y = y;
        this.left = left;
        this.up = up;
        this.status = status;
    }

    long findAll() {
        return left + up;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(3, 3, new int[][] {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        }));
        System.out.println(solution.solution(3, 3, new int[][] {
                {0, 2, 0, 0, 0, 2},
                {0, 0, 2, 0, 1, 0},
                {1, 0, 0, 2, 2, 0}
        }));
    }
}
