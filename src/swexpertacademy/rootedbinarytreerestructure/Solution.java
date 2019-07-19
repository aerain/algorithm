package swexpertacademy.rootedbinarytreerestructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int k;
        String[] arr;

        Map<Integer, int[][]> treeMap = new HashMap<>();

        for(int idx = 1; idx <= n; idx++) {
            k = Integer.parseInt(br.readLine());
            arr = br.readLine().split(" ");
            if(!treeMap.containsKey(k)) {
                int[][] treeStructure = new int[k][];
                treeStructure[0] = new int[] {(int) (Math.pow(2, k - 1) - 1) };

                for(int i = 0; i < k - 1; i++) {
                    treeStructure[i + 1] = new int[(int) Math.pow(2, i + 1)];

                    for(int j = 0; j < treeStructure[i].length; j++) {
                        treeStructure[i + 1][j * 2] = (int) (treeStructure[i][j] - Math.pow(2, k - 2 - i));
                        treeStructure[i + 1][j * 2 + 1] = (int) (treeStructure[i][j] + Math.pow(2, k - 2 - i));
                    }
                }
                treeMap.put(k, treeStructure);
            }



            sb.append('#').append(idx).append(' ');
            int[][] treeStructure = treeMap.get(k);
            for(int i = 0; i < k; i++) {
                for (int j = 0; j < treeStructure[i].length; j++) {
                    sb.append(arr[treeStructure[i][j]]).append(j == treeStructure[i].length - 1 ? '\n' : ' ');
                }
            }
        }
        System.out.println(sb.toString().trim());
    }
}
