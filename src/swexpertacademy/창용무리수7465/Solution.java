package swexpertacademy.창용무리수7465;

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        int N, M;
        int[][] relations;
        for(int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
            relations = new int[M][];
            for(int m = 0; m < M; m++) {
                st = new StringTokenizer(br.readLine(), " ");
                relations[m] = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
            }
            bw.write("#" + t + " " + solution(N, relations) + "\n");
        }
        br.close();
        bw.close();
    }

    private static int solution(int N, int[][] relations) {
        Set<Integer> member = new HashSet<>();
        List<HashSet<Integer>> existsRelationLists = new LinkedList<>();
        List<HashSet<Integer>> willRemove = new LinkedList<>();
        boolean findRelation;
        HashSet<Integer> matchedRelation = null;
        for(int[] relation : relations) {
            member.add(relation[0]);
            member.add(relation[1]);
            findRelation = false;
            for(HashSet<Integer> set : existsRelationLists) {
                if(set.contains(relation[0]) || set.contains(relation[1])) {
                    set.add(relation[0]);
                    set.add(relation[1]);
                    if(findRelation) {
                        matchedRelation.addAll(set);
                        willRemove.add(set);
                    } else {
                        findRelation = true;
                        matchedRelation = set;
                    }
                }
            }
            if(!findRelation) {
                HashSet<Integer> set = new HashSet<>();
                set.add(relation[0]);
                set.add(relation[1]);
                existsRelationLists.add(set);
            }
        }
        existsRelationLists.removeAll(willRemove);
        int answer = existsRelationLists.size();
        if(member.size() < N) {
            answer+=(N-member.size());
        }
        return answer;
    }
}
