package codewars.java;

import java.util.*;
public class UserInput {

    public static class TextInput {
        private StringBuilder sb;
        TextInput() { sb = new StringBuilder(); }
        public void add(char c) {
            sb.append(c);
        }
        public String getValue() { return sb.toString(); }
    }

    public static class NumericInput extends TextInput {
        @Override
        public void add(char c) {
            if(c >= '0' && c <= '9')
                super.add(c);
        }

    }

    public static void main(String[] args) {
        TextInput input = new NumericInput();
        input.add('1');
        input.add('a');
        input.add('0');
        System.out.println(input.getValue());
    }
}
