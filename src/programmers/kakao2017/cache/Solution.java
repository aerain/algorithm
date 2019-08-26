package programmers.kakao2017.cache;
import java.util.LinkedList;
public class Solution {
    public int solution(int cacheSize, String[] cities) {
        LinkedList<String> cache = new LinkedList<>();
        if(cacheSize == 0) return 5 * cities.length;
        int answer = 0;
        for(String city : cities) {
            city = city.toLowerCase();
            if(cache.contains(city)) {
                cache.remove(city);
                answer+=1;
            } else {
                if(cache.size() == cacheSize) cache.poll();
                answer+=5;
            }
            cache.offer(city);
        }
        return answer;
    }
}
