package goormtest.모의시험;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int rotate = Math.abs(Integer.parseInt(st.nextToken()));
        if(N % 2 == 1) rotate = -rotate;
        String[][] members = new String[N][];
        for(int i = 0; i < N; i++) members[i] = br.readLine().split(" ");

        String[][] rotatedMembers = new String[N][N];

        int start = 0;
        int end = N - 1;
        int optRotate, width;
        while(start > end) {
            width = end - start + 1;
            optRotate = rotate % (width * 4);
            if(optRotate > width * 2) optRotate = -((width * 4) - optRotate);

            if(optRotate < 0) {
                int limit = -optRotate;
                int origini = start;
                int originj = start;
                int rotatedi = end - start > limit ? start + limit : end;
                int rotatedj = end - start > limit ? start : start + limit - (end - start);

                while(limit > 0) {
                    if(originj == start && origini >= start && origini < end) {
                        rotatedMembers[rotatedi][rotatedj] = members[origini++][originj];

                    } else if(origini == end )
                    limit--;
                }
            } else if(optRotate > 0) {
                for(int i = 0; i < optRotate; i++) {

                }
            } else {

            }

            rotate = -rotate;
            start++;
            end--;
        }

        System.out.println(Arrays.deepToString(members));
        br.close();
        bw.close();
    }
}
