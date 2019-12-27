package codewars.java;

public class Snail {
    public static int[][] direction;

    static {
        direction = new int[][]{
                {0, 1},
                {1, 0},
                {0, -1},
                {-1, 0}
        };
    }

    public static int[] snail(int[][] array) {
        int length = array[0].length;
        if(length < 1) return new int[0];
        boolean[][] history = new boolean[length][length];
        int[] answer = new int[length * length];
        int directPos = 0;
        int stack = 0;
        int index = 0;
        int i = 0;
        int j = -1;
        while(stack < 3) {
            int willNexti = i + direction[directPos][0];
            int willNextj = j + direction[directPos][1];
            System.out.println(willNexti + ", " + willNextj);
            if(willNexti >= 0 && willNexti < length && willNextj >= 0 && willNextj < length && !history[willNexti][willNextj]) {
                if(stack > 0) stack = 0;
                history[willNexti][willNextj] = true;
                answer[index++] = array[willNexti][willNextj];
                i = willNexti;
                j = willNextj;
            } else {
                directPos = (directPos + 1) % 4;
                stack++;
            }
        }
        return answer;
    }
}
