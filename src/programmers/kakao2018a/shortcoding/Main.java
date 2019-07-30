package programmers.kakao2018a.shortcoding;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(solution(br.readLine()));
        bw.close();
        br.close();
    }

    private static String solution(String s) {
        LinkedHashMap<String, PriorityQueue<String>> equals = new LinkedHashMap<>();
        LinkedHashMap<String, String> notequals = new LinkedHashMap<>();
        
        String[] items = s.split("&&");

        String[] kv;

        for(String item : items) {
            kv = item.split("==");
            if(kv.length == 1) {
                kv = item.split("!=");
                if (isName(kv[0])) {
                    if (isName(kv[1])) {

                    } else {
                        
                    }
                }
                notequals.put(kv[0], kv[1]);
                continue;
            }

//            swap(kv);
//            equals.put(kv[0], kv[1]);
        }

        LinkedHashSet<String> list = new LinkedHashSet<>();
        return null;
    }
    private static PriorityQueue<String> newQueue() {
        return new PriorityQueue<>();
    }
    private static boolean isName(String s) {
        char arr[] = s.toCharArray();
        for(int i = 0; i < arr.length; i++) {
            if(!(arr[i] >= 'A' && arr[i] <= 'Z' || arr[i] >= 'a' && arr[i] <= 'z')) {
                return false;
            }
        }
        return true;
    }
}
