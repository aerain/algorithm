package codewars.java;

import java.util.LinkedList;
import java.util.Queue;

public class Boggle {
    private static int[][] direction;
    static {
        direction = new int[][] {
                {-1, -1},
                {-1, 0},
                {-1, 1},
                {0, 1},
                {1, 1},
                {1, 0},
                {1, -1},
                {0, -1}
        };
    }
    private char[][] board;
    private String word;
    public Boggle(final char[][] board, final String word) {
        // Your code here!
        this.board = board;
        this.word = word;
    }

    public boolean check() {
        // Your code here too!
        Queue<Word> queue = new LinkedList<>();
        char ch = word.charAt(0);

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(board[i][j] == ch) {
                    queue.offer(new Word(i, j, 1));
                }
            }
        }
        Word poll;
        while(!queue.isEmpty()) {
            poll = queue.poll();
            if(poll.index == word.length()) return true;
            for(int[] dr: direction) {
                int newI = poll.i + dr[0];
                int newJ = poll.j + dr[1];
                try {
                    if(board[newI][newJ] == word.charAt(poll.index)) {
                        queue.offer(new Word(newI, newJ, poll.index + 1));
                    }
                } catch(Exception ignored){}
            }
        }

        return false;
    }
    class Word {
        int i, j, index, prevI, prevJ;
        Word(int i, int j, int index) {
            this.i = i; this.j = j; this.index = index;
            this.prevI = -1; this.prevJ = -1;
        }
        Word(int i, int j, int index, int prevI, int prevJ) {
            this.i = i; this.j = j; this.index = index;
            this.prevI = prevI; this.prevJ = prevJ;
        }
    }
}
