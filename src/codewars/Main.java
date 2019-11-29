package codewars;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        System.out.println(MorseCodeDecoder.decode(".... . -.--   .--- ..- -.. ."));
        System.out.println(CamelCase.camelCase("test case"));
        System.out.println(CamelCase.camelCase("camel case method"));
        System.out.println(CamelCase.camelCase(" camel case word"));
        System.out.println(CamelCase.camelCase("z"));
        System.out.println(CamelCase.camelCase("ab  c"));
        System.out.println(CamelCase.camelCase(""));
    }
}
