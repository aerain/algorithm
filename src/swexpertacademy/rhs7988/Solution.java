package swexpertacademy.rhs7988;

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        int K;
        String[][] synergies;

        for(int t = 1; t <= T; t++) {
            K = Integer.parseInt(br.readLine());
            synergies = new String[K][];
            for(int k = 0; k < K; k++) synergies[k] = br.readLine().split(" ");
            bw.write("#" + t + " " + (solution(synergies) ? "Yes" : "No") + "\n");
        }
        br.close();
        bw.close();
    }

    private static boolean solution(String[][] synergies) {
        boolean answer = false;

        Map<String, ArrayList<String>> synergyMap = new HashMap<>();
        Set<String> allMembers = new HashSet<>();
        Set<String> A = new HashSet<>();
        Set<String> B = new HashSet<>();
        for(int i = 0; i < synergies.length; i++) {
            // 0일때는 우선 갖다 넣어.
            if(i == 0) {
                A.add(synergies[i][0]);
                B.add(synergies[i][1]);

                synergyMap.put(synergies[i][0], new ArrayList<>());
                synergyMap.get(synergies[i][0]).add(synergies[i][1]);
                synergyMap.put(synergies[i][1], new ArrayList<>());
                synergyMap.get(synergies[i][1]).add(synergies[i][0]);

                allMembers.add(synergies[i][0]);
                allMembers.add(synergies[i][1]);
                continue;
            }

            // 나머지는?

            if(A.contains(synergies[i][0])) {

            } else if(A.contains(synergies[i][1])) {

            } else {

            }
            allMembers.add(synergies[i][0]);
            allMembers.add(synergies[i][1]);
        }
        return answer;
    }
}

class Team {
    Set<String> one;
    Set<String> two;

    Team(Set<String> one, Set<String> two) {
        one = new HashSet<>(one);
        two = new HashSet<>(two);
    }
}
