package codewars.java;

public class Spiralizor {
    public static int[][] spiralize(int size) {
        int x = 0;
        int y = 1;
        int[][] board = new int[size][size];
        int i = 0, j = 0;
        board[i][j] = 1;
        while(true) {
            if(i + x >= 0 && i + x < size && j + y >= 0 && j + y < size && board[i + x][j + y] == 1) {
                int count = 0;
                if(i - 1 >= 0 && board[i - 1][j] == 1) count++;
                if(i + 1 < size && board[i + 1][j] == 1) count++;
                if(j - 1 >= 0 && board[i][j - 1] == 1) count++;
                if(j + 1 < size && board[i][j + 1] == 1) count++;
                if(count > 1)
                    board[i][j] = 0;
                break;
            }
            while(i + x >= 0 && i + x < size && j + y >= 0 && j + y < size) {
                if(i + 2 * x >= 0 && i + 2 * x < size && j + 2 * y >= 0 && j + 2 * y < size && board[i + 2 * x][j + 2 * y] == 1) break;
                board[i + x][j + y] = 1;
                i += x;
                j += y;
            }
            if(x == 0 && y == 1) {
                x = 1; y = 0;
            } else if(x == 1 && y == 0) {
                x = 0; y = -1;
            } else if(x == 0 && y == -1) {
                x = -1; y = 0;
            } else {
                x = 0; y = 1;
            }
        }
        return board;
    }
}
