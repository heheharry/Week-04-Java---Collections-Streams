package Day3.Regex.AdvancedProblems;
import java.util.regex.*;
public class RepeatingWordFinder {
    public static void main(String[] args) {
        String text = "This is is a repeated repeated word test.";
        String regex = "\\b(\\w+)\\s+\\1\\b";

        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println("Repeating word: " + matcher.group(1));
        }
    }
}
