package Day3.Regex.BasicRegexProblems;
import java.util.regex.*;
public class LicencePlateValidation {
    public static void main(String[] args) {
        String regex = "^[A-Z]{2}\\d{4}$";
        Pattern pattern = Pattern.compile(regex);

        String[] plates = {"AB1234", "A12345", "XY9999", "abc1234"};

        for (String plate : plates) {
            boolean isValid = pattern.matcher(plate).matches();
            System.out.println(plate + " → Valid: " + isValid);
        }
    }
}
