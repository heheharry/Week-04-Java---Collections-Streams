package Day2;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class TryWithResource {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("info.txt"))) {
            String line = reader.readLine();
            System.out.println(line);
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }
}
