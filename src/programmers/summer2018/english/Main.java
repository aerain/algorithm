package programmers.summer2018.english;

import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> history = new HashSet<>();
        char lastWord = ' ';
        boolean isChecked = false;
        int turn = 0;
        int index;
        for(index = 0; index < words.length; index++) {
            if(index % n == 0) turn++;
            if(history.contains(words[index]) || (index != 0 && lastWord != words[index].charAt(0)) ) {
                isChecked = true;
                break;
            }
            history.add(words[index]);
            lastWord = words[index].charAt(words[index].length() - 1);
        }

        index = (index + 1) % n;
        return isChecked ? new int[] {index == 0 ? n : index, turn } : new int[] { 0, 0 };
    }
}


public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(3, new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"})));
        System.out.println(Arrays.toString(solution.solution(5, new String[]{"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"})));
        System.out.println(Arrays.toString(solution.solution(2, new String[]{"hello", "one", "even", "never", "now", "world", "draw"})));
    }
}
