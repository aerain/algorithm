package programmers.bridge_truck;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int a = solution.solution(2, 10, new int[] {7, 4, 5, 6});
        int b = solution.solution(100, 100, new int[] {10});
        int c = solution.solution(100, 100, new int[] {10, 10, 10, 10, 10, 10, 10, 10, 10, 10});
        int d = solution.solution(2, 11, new int[] {1, 2, 8, 10});
//        int e = solution.solution(2, 10, new int[] {4, 6, 3, 7});

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
//        System.out.println(e);
    }
}
