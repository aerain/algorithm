package programmers.kakao2017.shuttlebus;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(1, 1, 5, new String[] { "08:00", "08:01", "08:02", "08:03" }));
        System.out.println(solution.solution(2, 10, 2, new String[] { "09:10", "09:09", "08:00" }));
        System.out.println(solution.solution(2, 1, 2, new String[] { "09:00", "09:00", "09:00", "09:00" }));
        System.out.println(solution.solution(1, 1, 5, new String[] { "00:01", "00:01", "00:01", "00:01", "00:01" }));
        System.out.println(solution.solution(1, 1, 1, new String[] { "23:59" }));
        System.out.println(solution.solution(10, 60, 45, new String[] { "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59" }));
        System.out.println(solution.solution(1, 1, 3, new String[] { "08:00", "08:01", "08:02", "08:04" })); // 08:01을 기대한다.
        System.out.println(solution.solution(2, 10, 2, new String[] { "09:09", "09:09", "08:00" })); // 09:08을 기대
        System.out.println(solution.solution(2, 10, 2, new String[] { "09:09", "09:00", "08:00" })); // 09:10을 기대
        System.out.println(solution.solution(1, 1, 2, new String[] { "09:00", "23:59", "08:00" })); // 08:59을 기대
        System.out.println(solution.solution(1, 1, 2, new String[] { "09:00", "09:00", "08:00" })); // 08:59을 기대
        System.out.println(solution.solution(1, 1, 2, new String[] { "09:00", "09:01", "08:00" })); // 08:59을 기대
    }
}
