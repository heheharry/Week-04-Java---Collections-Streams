package Day3.Regex.ReplaceAndModifyStrings;
import java.util.regex.*;
public class SensorBadWords {
    public static void main(String[] args) {
        String input = "This is a damn bad example with some stupid words.";
        String[] badWords = {"damn", "stupid"};

        String regex = "\\b(" + String.join("|", badWords) + ")\\b";

        String result = input.replaceAll(regex, "****");

        System.out.println("Original: " + input);
        System.out.println("Censored: " + result);
    }
}
