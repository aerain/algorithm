package swexpertacademy.우편함8189;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        int N, A, B;
        int[] letters;
        for(int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine(), " "); N = Integer.parseInt(st.nextToken()); A = Integer.parseInt(st.nextToken()); B = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine(), " "); letters = new int[N]; for(int n = 0; n < N; n++) letters[n] = Integer.parseInt(st.nextToken());
            bw.write("#" + t); for(int num : solution(A, B, letters)) bw.write(" " + num); bw.write("\n");
        }
        br.close();
        bw.close();
    }

    private static int[] solution(int a, int b, int[] letters) {
        Queue<Integer> posts = new LinkedList<>();
        Queue<Integer> times = new LinkedList<>();
        int time, index = 1;
        posts.offer(letters[0]);
        // 편지 받는중이에요
        while(!posts.isEmpty()) {
            // 편지가 다 도착해서 시간만 가는 경우나, 편지 확인하는 시간이 앞으로 편지 올 시간보다 빠를 때
            if(index == letters.length || b < letters[index] - posts.peek()) {
                time = posts.peek() + b;
                if(index != letters.length && time == letters[index]) {
                    posts.offer(letters[index]);
                    index++;
                }
            } else{  // 그렇지 않을때는 편지를 넣는 경우!
                time = letters[index];
                index++;
                posts.offer(time);
                if(posts.size() != a) continue;
            }
            int checkAmount = posts.size() / 2 + posts.size() % 2;
            for(int i = 0; i < checkAmount; i++) {
                posts.poll();
                times.offer(time);
            }

            if(posts.isEmpty() && index < letters.length) {
                posts.offer(letters[index]);
                index++;
            }
        }
        int[] answer = new int[times.size()];
        for(int i = 0; i < answer.length; i++) answer[i] = times.poll();
        return answer;
    }
}
