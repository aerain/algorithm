package codewars;

public class KataEncrypt {

    public static String encrypt(final String text, final int n) {
        // Your code here
        if(text == null || text.isBlank()) return text;
        String willEncrypt = text;
        for(int i = 0; i < n; i++) {
            StringBuilder second = new StringBuilder();
            StringBuilder first = new StringBuilder();
            char[] ch = willEncrypt.toCharArray();
            for(int j = 0; j < ch.length; j++) {
                if(j % 2 == 0) first.append(ch[j]);
                else second.append(ch[j]);
            }
            willEncrypt = second.append(first).toString();
        }
        return willEncrypt;
    }

    public static String decrypt(final String encryptedText, final int n) {
        // Your code here
        if(encryptedText == null || encryptedText.isBlank()) return encryptedText;
        String willDecrypt = encryptedText;
        for(int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            char[] second = willDecrypt.substring(0, encryptedText.length() / 2).toCharArray();
            char[] first = willDecrypt.substring(encryptedText.length() / 2).toCharArray();
            for(int j = 0; j < encryptedText.length(); j++) {
                sb.append(j % 2 == 0 ? first[j / 2] : second[j / 2]);
            }
            willDecrypt = sb.toString();
        }
        return willDecrypt;
    }

}
