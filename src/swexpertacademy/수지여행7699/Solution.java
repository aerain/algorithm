package swexpertacademy.수지여행7699;

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int R, C;
        char[][] map;
        StringTokenizer st;
        for(int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            map = new char[R][];
            for(int i = 0; i < R; i++) map[i] = br.readLine().toCharArray();

            bw.write("#" + t + " " + solution(R, C, map) + "\n");
        }

        br.close();
        bw.close();
    }
    static Set<Character> path;
    static int i, j, R, C, answer;
    static char[][] maps;
    private static int solution(int r, int c, char[][] map) {
        path = new HashSet<>();
        maps = map;
        answer = 0;
        i = 0; j = 0;
        R = r; C = c;
        dfs();
        return answer;
    }

    private static void dfs() {
        if(path.contains(maps[i][j])) return;
        path.add(maps[i][j]);
        if(i > 0) {
            i--;
            dfs();
            i++;
        }
        if(i < R - 1) {
            i++;
            dfs();
            i--;
        }
        if(j > 0) {
            j--;
            dfs();
            j++;
        }
        if(j < R - 1) {
            j++;
            dfs();
            j--;
        }
        answer = Math.max(answer, path.size());
        path.remove(maps[i][j]);
    }
}
