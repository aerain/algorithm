package codewars.java;

import java.util.Arrays;

public class Main {
    final private static char[][] board = {
            {'E','A','R','A'},
            {'N','L','E','C'},
            {'I','A','I','S'},
            {'B','Y','O','R'}
    };
    public static void main(String[] args) {
        System.out.println(new Boggle(board, "EAR").check());
        System.out.println(new Boggle(board, "EARS").check());
        System.out.println(new Boggle(board, "CEREAL").check());
    }
}
