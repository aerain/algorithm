package programmers.kakao2017.third.방금그곡;
public class Solution {
    public String solution(String m, String[] musicinfos) {
        m = change(m);
        Music[] musics = new Music[musicinfos.length];
        for(int i = 0; i < musicinfos.length; i++) {
            String[] arr = musicinfos[i].split(",");
            String[] start = arr[0].split(":");
            String[] end = arr[1].split(":");
            int duration = (Integer.parseInt(end[0]) * 60 + Integer.parseInt(end[1])) - (Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]));
            musics[i] = new Music(duration, arr[2], change(arr[3]));
        }
        Music answer = null;
        for(Music music : musics) {
            if(!isCorrect(music.note, m)) continue;
            if (answer == null || answer.duration < music.duration) answer = music;
        }

        return answer == null ? "(None)" : answer.writer;
    }
    public String change(String s) {
        return s.replace("C#", "c")
                .replace("D#", "d")
                .replace("F#", "f")
                .replace("G#", "g")
                .replace("A#", "a");
    }
    public boolean isCorrect(String note, String m) {
        int length = m.length();
        for(int index = note.indexOf(m); index >= 0; index = note.indexOf(m, index + 1)) {
            int end = index + length;
            if(end >= note.length() || note.charAt(end) != '#') return true;
        }
        return false;
    }
}

class Music {
    int duration;
    String writer;
    String note;
    Music(int duration, String writer, String note) {
        this.duration = duration;
        this.writer = writer;
        this.note = getNote(note);
    }
    private String getNote(String s) {
        if(duration < s.length()) return s.substring(0, duration);
        else if (duration == s.length()) return s;
        else {
            StringBuilder sb = new StringBuilder();
            int rest = duration;
            while(rest > 0) {
                if(rest < s.length()) {
                    sb.append(s, 0, rest);
                    rest = 0;
                } else {
                    sb.append(s);
                    rest -= s.length();
                }
            }
            return sb.toString();
        }
    }
}
