package codewars;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Chess {
    public static int knight(String start, String  finish) {
        int boardSize = 8;
        int[][] board = new int[boardSize][];
        Point startP = new Point(start);
        Point endP = new Point(finish);
        for(int i = 0; i < 8; i++) {
            board[i] = new int[boardSize];
            Arrays.fill(board[i], Integer.MAX_VALUE);
        }
        board[startP.x][startP.y] = 0;

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(startP.x, startP.y));
        Point poll;
        while(!queue.isEmpty()) {
            poll = queue.poll();
            if(poll.x - 2 >= 0 && poll.y - 1 >= 0 && board[poll.x - 2][poll.y - 1] > board[poll.x][poll.y] + 1) {
                board[poll.x - 2][poll.y - 1] = board[poll.x][poll.y] + 1;
                queue.offer(new Point(poll.x - 2, poll.y - 1));
            }
            if(poll.x - 1 >= 0 && poll.y - 2 >= 0 && board[poll.x - 1][poll.y - 2] > board[poll.x][poll.y] + 1) {
                board[poll.x - 1][poll.y - 2] = board[poll.x][poll.y] + 1;
                queue.offer(new Point(poll.x - 1, poll.y - 2));
            }
            if(poll.x - 2 >= 0 && poll.y + 1 < boardSize && board[poll.x - 2][poll.y + 1] > board[poll.x][poll.y] + 1) {
                board[poll.x - 2][poll.y + 1] = board[poll.x][poll.y] + 1;
                queue.offer(new Point(poll.x - 2, poll.y + 1));
            }
            if(poll.x - 1 >= 0 && poll.y + 2 < boardSize && board[poll.x - 1][poll.y + 2] > board[poll.x][poll.y] + 1) {
                board[poll.x - 1][poll.y + 2] = board[poll.x][poll.y] + 1;
                queue.offer(new Point(poll.x - 1, poll.y + 2));
            }
            if(poll.x + 2 < boardSize && poll.y - 1 >= 0 && board[poll.x + 2][poll.y - 1] > board[poll.x][poll.y] + 1) {
                board[poll.x + 2][poll.y - 1] = board[poll.x][poll.y] + 1;
                queue.offer(new Point(poll.x + 2, poll.y - 1));
            }
            if(poll.x + 1 < boardSize && poll.y - 2 >= 0 && board[poll.x + 1][poll.y - 2] > board[poll.x][poll.y] + 1) {
                board[poll.x + 1][poll.y - 2] = board[poll.x][poll.y] + 1;
                queue.offer(new Point(poll.x + 1, poll.y - 2));
            }
            if(poll.x + 2 < boardSize && poll.y + 1 < boardSize && board[poll.x + 2][poll.y + 1] > board[poll.x][poll.y] + 1) {
                board[poll.x + 2][poll.y + 1] = board[poll.x][poll.y] + 1;
                queue.offer(new Point(poll.x + 2, poll.y + 1));
            }
            if(poll.x + 1 < boardSize && poll.y + 2 < boardSize && board[poll.x + 1][poll.y + 2] > board[poll.x][poll.y] + 1) {
                board[poll.x + 1][poll.y + 2] = board[poll.x][poll.y] + 1;
                queue.offer(new Point(poll.x + 1, poll.y + 2));
            }
        }
        return board[endP.x][endP.y];
    }
}

class Point {
    int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    Point(String s) {
        x = Character.compare(s.charAt(0), 'a');
        y = Character.compare(s.charAt(1), '1');
    }
}
