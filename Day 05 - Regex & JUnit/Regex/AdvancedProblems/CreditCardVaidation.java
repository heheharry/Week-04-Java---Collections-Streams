package Day3.Regex.AdvancedProblems;
import java.util.regex.*;
public class CreditCardVaidation {
    public static void main(String[] args) {
        String regex = "^(4\\d{15}|5\\d{15})$";
        Pattern pattern = Pattern.compile(regex);

        String[] cards = {
                "4123456789012345",
                "5123456789012345",
                "6123456789012345",
                "41234567890123",
                "51234567890123456"
        };

        for (String card : cards) {
            boolean isValid = pattern.matcher(card).matches();
            System.out.println(card + " → Valid: " + isValid);
        }
    }
}
