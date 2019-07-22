package programmers.kakao2017.bryan;

import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    List<Character> list;
    boolean isPattern(char ch) {
        return ch >= 'a' && ch <= 'z';
    }

    public StringBuilder sai(char[] array) {
        StringBuilder sb = new StringBuilder();
        boolean isPlainText = CharBuffer.wrap(array).chars().parallel().mapToObj(ch -> (char) ch).noneMatch(this::isPattern);
        if(isPlainText) sb.append(array);
        else {
        }
        return sb;
    }

    public String solution(String sentence) {

        char[] sentenceArray = sentence.toCharArray();
        list = new ArrayList<>();
        StringBuilder answer = new StringBuilder();
        StringBuilder willAppendString;

        int idx = 0;

        while (idx < sentenceArray.length) {
            // aBBBBBa or aBcBcBa 를 찾기, 감싸는 내부를 잘라서 또 실행
            if(isPattern(sentenceArray[idx])) {
                char pattern = sentenceArray[idx];

                if(list.contains(pattern)) return "invalid";
                else list.add(pattern);

                int start = idx;
                while(idx < sentenceArray.length && pattern != sentenceArray[idx]) idx++;
                answer.append(sai(Arrays.copyOfRange(sentenceArray, start, idx)));
            } else {

            }
            idx++;
        }
        System.out.println("최종: " + answer.toString());
        return answer.toString();
    }
}
