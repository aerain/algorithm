package codewars.java;

import java.util.List;

public class RegExpParser {
    private final char[] input;
    public RegExpParser(final String input) {
        // Your code here!
        this.input = input.toCharArray();
    }

    public RegExpParser(final char[] input) {
        this.input = input;
    }

    public RegExp parse() {
        // Your code here!
        return new Void();
    }

    static class RegExp {

    }
    static class Void extends RegExp {
    }

    static class Normal extends RegExp {
        Normal(char c) {}
    }

    static class Any extends RegExp {

    }

    static class ZeroOrMore extends RegExp {
        ZeroOrMore(RegExp regExp) {}
    }

    static class Or extends RegExp {
        Or(RegExp r1, RegExp r2) {}
    }

    static class Str extends RegExp {
        Str(List<RegExp> lstRegexps) {}
    }
}
