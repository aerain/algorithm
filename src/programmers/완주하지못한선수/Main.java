package programmers.완주하지못한선수;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(
                new String[] { "marina", "josipa", "nikola", "vinko", "filipa"},
                new String[] { "josipa", "filipa", "marina", "nikola" }
        ));

        System.out.println(solution.solution(
                new String[] { "mislav", "stanko", "mislav", "ana" },
                new String[] { "stanko", "ana", "mislav" }
        ));


    }
}
