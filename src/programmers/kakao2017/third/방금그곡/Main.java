package programmers.kakao2017.third.방금그곡;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("ABCDEFG", new String[] { "12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF" }));
        System.out.println(solution.solution("CC#BCC#BCC#BCC#B", new String[] { "03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B" }));
        System.out.println(solution.solution("ABC", new String[] { "12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF" }));
        System.out.println(solution.solution("C#D#C#D#F#", new String[] { "12:00,12:14,HELLO,C#D#C#D#C#D#F#" }));
    }
}
