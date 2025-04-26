package Day3.Regex.AdvancedProblems;
import java.util.regex.*;
public class IPAddressValidation {
    public static void main(String[] args) {
        String regex = "^(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)"
                + "(\\.(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)){3}$";

        String[] ips = {
                "192.168.0.1",
                "255.255.255.255",
                "256.100.100.100",
                "192.168.0",
                "01.02.03.04"
        };

        for (String ip : ips) {
            boolean isValid = ip.matches(regex);
            System.out.println(ip + " → Valid: " + isValid);
        }
    }
}
