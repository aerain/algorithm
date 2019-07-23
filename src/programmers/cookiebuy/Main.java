package programmers.cookiebuy;

import java.util.*;

class Solution {
    public int solution(int[] cookie) {
        int answer = 0;
        Queue<Cookie> cookieQueue = new LinkedList<>();
        Set<Cookie> cookieSet = new HashSet<>();
        // 처음은 반띵하고 시작, 홀수인경우 둘째가 하나 일단 더 가져놔
        Cookie status = new Cookie(0, cookie.length, cookie.length % 2 == 0 ? cookie.length / 2 - 1 : Math.floorDiv(cookie.length, 2) + 1);
        Cookie temp;
        cookieQueue.offer(status);
        cookieSet.add(status);
        int firstSum;
        int secondSum;
        // 하드코딩... limit...
        int limit = 64;
        int count = 0;
        while(!cookieQueue.isEmpty()) {
            try {
                status = cookieQueue.poll();
                firstSum = 0;
                secondSum = 0;
                for(int i = status.firstIndex; i < status.m + 1; i++) firstSum += cookie[i];
                for(int i = status.m + 1; i < status.secondIndex; i++) secondSum += cookie[i];

                if(firstSum > secondSum) {
                    temp = new Cookie(status.firstIndex + 1, status.secondIndex, status.m);
                    if(!cookieSet.contains(temp)) {
                        cookieQueue.offer(temp);
                        cookieSet.add(temp);
                    }

                    temp = new Cookie(status.firstIndex, status.secondIndex, status.m - 1);
                    if(!cookieSet.contains(temp)) {
                        cookieQueue.offer(temp);
                        cookieSet.add(temp);
                    }
                } else if(firstSum < secondSum) {
                    temp = new Cookie(status.firstIndex, status.secondIndex - 1, status.m);
                    if(!cookieSet.contains(temp)) {
                        cookieQueue.offer(temp);
                        cookieSet.add(temp);
                    }

                    temp = new Cookie(status.firstIndex, status.secondIndex, status.m + 1);
                    if(!cookieSet.contains(temp)) {
                        cookieQueue.offer(temp);
                        cookieSet.add(temp);
                    }

                } else {
                    if(firstSum > answer) answer = firstSum;

                }

                if(count == limit) {
                    if(answer != 0) break;
                    else limit *= limit;
                }
                count++;
            } catch (Exception ignored) {}
        }

        return answer;
    }
}

class Cookie {
    int firstIndex, secondIndex, m;
    public Cookie(int firstIndex, int secondIndex, int m) {
        this.firstIndex = firstIndex;
        this.secondIndex = secondIndex;
        this.m = m;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;

        if(obj instanceof Cookie) {
            Cookie cookie = (Cookie) obj;
            return this.firstIndex == cookie.firstIndex && this.secondIndex == cookie.secondIndex && this.m == cookie.m;
        }

        return false;
    }

    @Override
    public int hashCode() {
        return m;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[] { 1, 1, 2, 3}));
        System.out.println(solution.solution(new int[] { 1, 2, 4, 5}));
        System.out.println(solution.solution(new int[] { 3, 4, 6, 2}));
    }
}
