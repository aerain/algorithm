package programmers.kakao2017.friends4block;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int solution(int m, int n, String[] board) {
        int total = 0;
        int answer = 0;
        char[][] boards = new char[board.length][];
        for(int l = 0; l < board.length; l++) boards[l] = board[l].toCharArray();
        boolean[][] history;

        Queue<Point> queue = new LinkedList<>();
        Point p;
        while(true) {
            history = new boolean[boards.length][boards[0].length];
            for(int i = 0; i < boards.length - 1; i++) {
                for(int j = 0; j < boards[0].length - 1; j++) {
                    if(history[i][j] || boards[i][j] == ' ') continue;
                    queue.offer(new Point(i, j));
                    while(!queue.isEmpty()) {

                        p = queue.poll();
                        try {
                            if (boards[p.i][p.j] == boards[p.i][p.j + 1] && boards[p.i][p.j] == boards[p.i + 1][p.j] && boards[p.i][p.j] == boards[p.i + 1][p.j + 1]) {
                                if (!history[p.i][p.j]) {
                                    history[p.i][p.j] = true;
                                    answer++;
                                }
                                if (!history[p.i][p.j + 1]) {
                                    history[p.i][p.j + 1] = true;
                                    answer++;
                                    queue.offer(new Point(p.i, p.j + 1));
                                }
                                if (!history[p.i + 1][p.j]) {
                                    history[p.i + 1][p.j] = true;
                                    answer++;
                                    queue.offer(new Point(p.i + 1, p.j));
                                }
                                if (!history[p.i + 1][p.j + 1]) {
                                    history[p.i + 1][p.j + 1] = true;
                                    answer++;
                                    queue.offer(new Point(p.i + 1, p.j + 1));
                                }
                            }
                        } catch (Exception ignore) {
                            //네모를 만들수 없는 경우.
                        }

                    }
                }
            }
            total+=answer;
            if(answer > 0) {
                // 밑으로 깔아주자.
                int pushCount = 0;
                for(int j = 0; j < boards[0].length; j++) {
                    for(int i = board.length - 1; i >= 0; i--) {
                        if(history[i][j]) {
                            boards[i][j] = ' ';
                            pushCount++;
                        } else {
                            if(pushCount > 0) {
                                boards[i + pushCount][j] = boards[i][j];
                                boards[i][j] = ' ';
                            }
                        }
                    }
                    // 다 처리했으면 초기화.
                    pushCount = 0;
                }
                answer = 0;
            } else {
                break;
            }
        }
        return total;
    }
}

class Point {
    int i, j;
    Point(int i, int j) { this.i = i; this.j = j;}
}