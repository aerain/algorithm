package programmers.베스트앨범;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public int[] solution(String[] genres, int[] plays) {
        return IntStream.range(0, genres.length)
                .mapToObj(i -> new Music(genres[i], plays[i], i))
                .collect(Collectors.groupingBy(x -> x.genre))
                .entrySet().stream()
                .sorted((a, b) -> sum(b.getValue()) - sum(a.getValue()))
                .flatMap(x -> x.getValue().stream().sorted().limit(2))
                .mapToInt(x -> x.id)
                .toArray();
    }
    int sum(List<Music> value) {
        int answer = 0;
        for(Music music: value) {
            answer += music.play;
        }
        return answer;
    }
}

class Music implements Comparable<Music> {
    int id;
    String genre;
    int play;
    public Music(String genre, int play, int id) {
        this.genre = genre;
        this.play = play;
        this.id = id;
    }

    @Override
    public int compareTo(Music o) {
        if(this.play == o.play) return Integer.compare(this.id, o.id);
        return Integer.compare(o.play, this.play);
    }
}
