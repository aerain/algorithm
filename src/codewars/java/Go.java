package codewars.java;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Go {
    private static final int[][] near = { {-1, 0}, {0, -1}, {1, 0}, {0, 1} };
    private char[][] board;
    // false is x turn, true is o turn;
    private boolean turn;

    public Go(int size) {
        board = new char[size][];
        turn = false;
        for(char[] row: board) Arrays.fill(row, '.');
    }

    public char[][] getBoard() { return this.board; }

    public void move(String pos) {
        int posX = Character.compare(pos.charAt(0), '1');
        int posY = Character.compare(pos.charAt(1), 'A');
        board[posX][posY] = turn ? 'o' : 'x';
        for(int[] n: near) {
            if(posX + n[0] >= 0 && posX + n[0] < board.length && posY + n[1] >= 0 && posY + n[1] < board.length && board[posX + n[0]][posY + n[1]] == (turn ? 'x' : 'o')) {
                findAndCaptureIfCan(posX + n[0], posY + n[1]);
            }
        }
        turn = !turn;
    }

    private void findAndCaptureIfCan(int posX, int posY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { posX, posY });
        while(!queue.isEmpty()) {

        }
    }

    public static class Point {
        char value;
        int liberties;
    }

}
