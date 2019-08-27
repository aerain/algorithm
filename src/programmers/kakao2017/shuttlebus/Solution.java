package programmers.kakao2017.shuttlebus;

import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
    public String solution(int N, int T, int M, String[] timetable) {
        PriorityQueue<Time> crewQueue = new PriorityQueue<>(timetable.length, Time::compareTo);

        // 정렬
        StringTokenizer st;
        for(String time: timetable) {
            st = new StringTokenizer(time, ":");
            crewQueue.offer(new Time(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), false));
        }

        Time time = null, crew, corn = new Time(0, 0, false);
        for(int n = 1; n <= N; n++) {
            time = new Time(n, T, true);
            int m;
            for(m = 1; m <= M; m++) {
                // 큐에 사람이 없다.
                // 마지막에 자리가 있으면 맨 마지막 셔틀타고 감.
                if(crewQueue.isEmpty()) return new Time(N, T, true).toString();

                //버스시간보다 일찍 왔다면?
                if(crewQueue.peek().compareTo(time) <= 0) {
                    //태운다. 여기서 로그를 쌓자.
                    //매 회차마다 가장 늦게 탈 수 있는 경우의 수를 쌓자.
                    // 그게 아니면?
                    crew = crewQueue.poll();
                    if(corn.compareTo(crew) < 0) {
                        corn = crew;
                    }
                } else { // 나머지는 버스시간보다 늦게 왔으니까 다음 차 타야지
                    break;
                }
            }
            // 자리가 남으면 그대로 가고 자리가 안남으면 더 앞에 가야지.
            if(m > M) corn.getEarly();
            else corn = time;
        }
        // 모든 버스는 떠나갔다.
        // 셔틀시간에 못온사람 혹은 못탄사람 둘중 하나다.
        return corn.toString();
    }
}

class Time implements Comparable<Time> {
    int hour, minute;
    Time(int n, int t, boolean isBus) {
        if(isBus) {
            int minute = 540 + ((n - 1) * t);
            this.hour = minute / 60;
            this.minute = minute % 60;
        } else {
            this.hour = n; this.minute = t;
        }
    }
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Time) {
            Time time = (Time) obj;
            return this.hour == time.hour && this.minute == time.minute;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return 60 * hour + minute;
    }

    @Override
    public String toString() {
        return (Math.log10(hour) < 1 ? 0 + String.valueOf(hour) : hour) + ":" + (Math.log10(minute) < 1 ? 0 + String.valueOf(minute) :  minute);
    }

    @Override
    public int compareTo(Time o) {
        if(this.hour > o.hour) return 1;
        else if(this.hour < o.hour) return -1;
        else return Integer.compare(this.minute, o.minute);
    }

    void getEarly() {
        if(this.minute == 0) {
            this.minute = 59;
            this.hour--;
        } else {
            this.minute --;
        }
    }
}
