package Day3.Regex.ExtractionProblems;
import java.util.regex.*;
public class LinkExtractor {
    public static void main(String[] args) {
        String text = "Visit https://www.google.com and http://example.org for more info.";
        String regex = "https?://[\\w.-]+";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println("Link: " + matcher.group());
        }
    }
}
