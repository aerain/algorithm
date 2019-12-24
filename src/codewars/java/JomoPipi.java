package codewars.java;

public class JomoPipi {
    public static String stringFunc(String s, long x) {
        //code here
//        x = x % (s.length() - 1);

//        x = (long) Math.ceil((Math.log(x) / Math.log(2))) + 1;

        int i = 1;
        StringBuilder sb = new StringBuilder();
        while(i <= x) {
            sb.setLength(0);
            char[] ch = s.toCharArray();
            int a = ch.length - 1;
            int b = 0;
            boolean c = false;
            while(a >= b) {
                sb.append(ch[c ? b++ : a--]);
                c = !c;
            }
            s = sb.toString();
            System.out.println(s);
            i++;
        }

        /*
        abcd
        dacb
        bdca
        abcd
         */
        return s;
    }
}
