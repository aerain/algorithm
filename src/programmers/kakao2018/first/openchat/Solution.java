package programmers.kakao2018.first.openchat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public String[] solution(String[] records) {
        Map<String, String> idMap = new HashMap<>();
        List<History> historyList = new ArrayList<>();
        for(String record: records) {
            String[] split = record.split(" ");
            switch(split[0]) {
                case "Change": idMap.put(split[1], split[2]); break;
                case "Enter": historyList.add(new History(split[1], true)); idMap.put(split[1], split[2]); break;
                case "Leave": historyList.add(new History(split[1], false)); break;
            }
        }
        String[] answer = new String[historyList.size()];
        for(int i = 0; i < answer.length; i++) {
            History history = historyList.get(i);
            answer[i] = String.format("%s님이 %s습니다.", idMap.get(history.uid), history.isJoin ? "들어왔" : "나갔");
        }
        return answer;
    }
}

class History {
    String uid;
    boolean isJoin;
    History(String uid, boolean isJoin) {
        this.uid = uid; this.isJoin = isJoin;
    }
}