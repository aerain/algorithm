package programmers.완주하지못한선수;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {
    public String solution(String[] participants, String[] completions) {
        Map<String, Long> participantMap = Arrays.stream(participants).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<String, Long> completionMap = Arrays.stream(completions).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        List<String> participantSet = new ArrayList<>(participantMap.keySet());
        List<String> completionSet = new ArrayList<>(completionMap.keySet());

        Collections.sort(participantSet);
        Collections.sort(completionSet);

        Iterator<String> parIterator = participantSet.iterator();
        Iterator<String> complIterator = completionSet.iterator();

        while(complIterator.hasNext()) {
            String participant = parIterator.next();
            String completion = complIterator.next();

            if(!participant.equals(completion)) return participant;
            if(participantMap.get(participant) > completionMap.get(completion)) return participant;
        }
        return parIterator.next();
    }
}
