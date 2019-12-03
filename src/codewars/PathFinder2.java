package codewars;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class PathFinder2 {
    public static int pathFinder(String maze) {
        String[] mazesplit = maze.split("\n");
        char[][] mazeArr = new char[mazesplit.length][];

        for(int i = 0; i < mazeArr.length; i++) {
            mazeArr[i] = mazesplit[i].toCharArray();
        }

        int[][] shortestPath = new int[mazeArr.length][];
        for(int i = 0; i < shortestPath.length; i++) {
            shortestPath[i] = new int[mazeArr.length];
            for(int j = 0; j < shortestPath.length; j++) {
                shortestPath[i][j] = mazeArr[i][j] == 'W' ? -1 : Integer.MAX_VALUE;
            }
        }

        for(char[] m: mazeArr) System.out.println(Arrays.toString(m));

        int[][] pathCase = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        Queue<PathPoint> queue = new LinkedList<>();
        queue.offer(new PathPoint(0, 0, 0));
        PathPoint poll;
        int sum = Integer.MAX_VALUE;
        while(!queue.isEmpty()) {
            poll = queue.poll();
            if(shortestPath[poll.i][poll.j] <= poll.route) continue;
            shortestPath[poll.i][poll.j] = poll.route;

            for(int[] path: pathCase) {
                if(poll.i + path[0] >= 0 && poll.i + path[0] < shortestPath.length && poll.j + path[1] >= 0 && poll.j + path[1] < shortestPath.length)
                    queue.offer(new PathPoint(poll.route + 1, poll.i + path[0], poll.j + path[1]));
            }
        }

        return shortestPath[shortestPath.length - 1][shortestPath.length - 1] == Integer.MAX_VALUE ? -1 : shortestPath[shortestPath.length - 1][shortestPath.length - 1];
    }
}

class PathPoint {
    int route;
    int i, j;
    public PathPoint(int route, int i, int j) {
        this.route = route;
        this.i = i;
        this.j = j;
    }
}
