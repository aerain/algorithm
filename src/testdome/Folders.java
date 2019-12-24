package testdome;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Folders {
    public static Collection<String> folderNames(String xml, char startingLetter) throws Exception {
        // (?<=name=")u[^</>"]*(?=".*( \/)?>)|((?<=name=')u[^</>']*(?='.*( \/)?>))
        Matcher matcher = Pattern.compile(
                "(?<=name=\")"
                + startingLetter +
                "[^</>\"]*(?=\".*( /)?>)|((?<=name=')"
                + startingLetter +
                "[^</>']*(?='.*( /)?>))").matcher(xml);
        List<String> folderNames = new ArrayList<>();
        while(matcher.find()) {
            folderNames.add(matcher.group());
        }
        return folderNames;
    }

    public static void main(String[] args) throws Exception {
        String xml =
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                        "<folder name=\"c\">" +
                        "<folder name=\"program files\">" +
                        "<folder name=\"uninstall information\" />" +
                        "</folder>" +
                        "<folder name=\"users\" />" +
                        "</folder>";

        Collection<String> names = folderNames(xml, 'u');
        for(String name: names)
            System.out.println(name);
    }
}
