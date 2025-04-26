package Day3.Regex.BasicRegexProblems;
import java.util.regex.*;
public class HexColorvalidation {
    public static void main(String[] args) {
        String regex = "^#[0-9A-Fa-f]{6}$";
        Pattern pattern = Pattern.compile(regex);

        String[] colors = {"#FFA500", "#ff4500", "#123", "#ZZZZZZ"};

        for (String color : colors) {
            boolean isValid = pattern.matcher(color).matches();
            System.out.println(color + " → Valid: " + isValid);
        }
    }
}
