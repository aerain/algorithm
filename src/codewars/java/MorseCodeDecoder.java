package codewars.java;

public class MorseCodeDecoder {
    public static String decode(String morseCode) {
        // your brilliant code here, remember that you can access the preloaded Morse code table through MorseCode.get(code)
        StringBuilder sb = new StringBuilder();
        for(String str: morseCode.trim().replace("   ", " 0 ").split(" ")) {
            sb.append(str.equals("0") ? " " : MorseCode.get(str));
        }
        return sb.toString();
    }
}

class MorseCode {
    public static char[] get(String str) {
        return new char[0];
    }
}
