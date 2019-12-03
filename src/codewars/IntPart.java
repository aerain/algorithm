package codewars;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IntPart {
    public static String part(long n) {
        List<Long> list = new ArrayList<>();
        int a, b;
        for(long i = 1; i <= n; i++) {
            a = 2;
            b = list.size() - 3;
            while(a < b) {
                long value = a * list.get(b);
                if(!list.contains(value)) list.add(value);
                a++;
                b--;
            }
            if(!list.contains(i)) list.add(i);
        }
        return list.toString();
    }
}
