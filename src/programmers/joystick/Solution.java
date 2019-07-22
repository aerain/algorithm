package programmers.joystick;

import java.util.Arrays;

public class Solution {

    private int getCount(char ch) {
        return Math.min(ch - 'A', 'A' + 26 - ch);
    }

    public int solution(String name) {
        char[] origin = name.toCharArray();
        char[] rightOriented = new char[origin.length];
        char[] leftOriented = new char[origin.length];

        Arrays.fill(rightOriented, 'A');
        Arrays.fill(leftOriented, 'A');
        // right
        int ridx = 0;
        int rAns = 0;
        while (ridx < rightOriented.length) {
            rightOriented[ridx] = origin[ridx];
            rAns += getCount(rightOriented[ridx]);
            if(Arrays.equals(origin, rightOriented)) break;
            rAns++;
            ridx++;
        }
        // left
        int lidx = 0;
        int lAns = 0;
        while(lidx >= 0) {
            leftOriented[lidx] = origin[lidx];
            lAns += getCount(leftOriented[lidx]);
            if(Arrays.equals(origin, leftOriented)) break;
            lAns++;
            lidx--;
            if(lidx < 0) lidx = leftOriented.length - 1;
        }

        return Math.min(lAns, rAns);
    }
}
