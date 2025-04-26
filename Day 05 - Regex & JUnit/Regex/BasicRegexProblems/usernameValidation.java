package Day3.Regex.BasicRegexProblems;
import java.util.regex.*;
public class usernameValidation {
    public static void main(String[] args) {
        String regex = "^[a-zA-Z][a-zA-Z0-9_]{4,14}$";
        Pattern pattern = Pattern.compile(regex);

        String[] usernames = {"user_123", "123user", "us"};

        for (String username : usernames) {
            boolean isValid = pattern.matcher(username).matches();
            System.out.println(username + " → Valid: " + isValid);
        }
    }
}
