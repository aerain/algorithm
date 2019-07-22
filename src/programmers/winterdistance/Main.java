package programmers.winterdistance;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        char[] directions = dirs.toCharArray();

        History[][] histories = new History[11][11];
        for(int i = 0; i < 11; i++) {
            for(int j = 0; j < 11; j++) {
                histories[i][j] = new History();
            }
        }

        int m = 5;
        int n = 5;

        for(char direction: directions) {
            try {
                switch(direction) {
                    case 'U':
                        if(!histories[m - 1][n].down) {
                            answer++;
                            histories[m - 1][n].down = true;
                            histories[m][n].up = true;
                        }
                        m--;
                        break;
                    case 'D':
                        if(!histories[m + 1][n].up) {
                            answer++;
                            histories[m + 1][n].up = true;
                            histories[m][n].down = true;
                        }
                        m++;
                        break;
                    case 'R':
                        if(!histories[m][n + 1].left) {
                            answer++;
                            histories[m][n + 1].left = true;
                            histories[m][n].right = true;
                        }
                        n++;
                        break;
                    case 'L':
                        if(!histories[m][n - 1].right) {
                            answer++;
                            histories[m][n - 1].right = true;
                            histories[m][n].left = true;
                        }
                        n--;
                        break;
                }
            } catch (Exception ignored) {}
        }
        return answer;
    }
}

class History {
    boolean left, right, up, down;
}


public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("ULURRDLLU"));
        System.out.println(solution.solution("LULLLLLLU"));
        System.out.println(solution.solution("UDUDUDUD"));
    }
}
