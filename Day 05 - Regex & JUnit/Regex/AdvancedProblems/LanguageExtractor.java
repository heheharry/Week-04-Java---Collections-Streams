package Day3.Regex.AdvancedProblems;
import java.util.regex.*;
public class LanguageExtractor {
    public static void main(String[] args) {
        String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";
        String regex = "\\b(Java|Python|JavaScript|Go|C\\+\\+|C#|Ruby|Swift|Kotlin|Rust|TypeScript)\\b";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println("Language: " + matcher.group());
        }
    }
}
