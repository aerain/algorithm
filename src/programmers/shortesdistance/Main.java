package programmers.shortesdistance;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[][] maps) {
        int m = maps.length;
        int n = maps[0].length;
        Direction[] directions = new Direction[] {
                new Direction(1, 0),
                new Direction( -1, 0),
                new Direction(0, 1),
                new Direction(0, -1)
        };
        Coord[][] coords = new Coord[m][n];
        // initialize
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                coords[i][j] = new Coord(i, j, Integer.MAX_VALUE);
            }
        }

        //algorithm
        coords[0][0].distance = 1;

        Queue<Coord> queue = new LinkedList<>();
        queue.offer(coords[0][0]);
        Coord coord;
        while (!queue.isEmpty()) {
            coord = queue.poll();
            for (Direction direction : directions) {
                try {
                    if (maps[coord.x + direction.x][coord.y + direction.y] == 1 && coords[coord.x + direction.x][coord.y + direction.y].distance > coords[coord.x][coord.y].distance + 1) {
                        coords[coord.x + direction.x][coord.y + direction.y].distance = coords[coord.x][coord.y].distance + 1;
                        queue.offer(coords[coord.x + direction.x][coord.y + direction.y]);
                    }
                } catch (Exception ignored) {}
            }
        }
        return coords[m - 1][n - 1].distance != Integer.MAX_VALUE ? coords[m - 1][n - 1].distance : -1;
    }
}

class Direction {
    int x, y;
    Direction(int x, int y) {
        this.x = x;
        this.y = y;
    }
}


class Coord {
    int x, y, distance;
    Coord(int x, int y, int distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[][] {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1}
        }));
        System.out.println();
        System.out.println(solution.solution(new int[][] {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 0},
                {0, 0, 0, 0, 1}
        }));
    }
}
