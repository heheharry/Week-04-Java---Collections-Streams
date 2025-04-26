package Day3.Regex.AdvancedProblems;
import java.util.regex.*;
public class SSNValidator {
    public static void main(String[] args) {
        String[] ssns = {
                "123-45-6789",
                "123456789",
                "000-00-0000",
                "12-345-6789"
        };

        String regex = "^\\d{3}-\\d{2}-\\d{4}$";
        Pattern pattern = Pattern.compile(regex);

        for (String ssn : ssns) {
            boolean isValid = pattern.matcher(ssn).matches();
            System.out.println("\"" + ssn + "\" is valid: " + isValid);
        }
    }
}
