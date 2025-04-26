package Day1;
import java.io.*;
public class UserInputToFile {
    public static void main(String[] args) {
        String outputFile = "user_info.txt";

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileWriter writer = new FileWriter(outputFile)) {

            System.out.print("Enter your name: ");
            String name = reader.readLine();

            System.out.print("Enter your age: ");
            String age = reader.readLine();

            System.out.print("Enter your favorite programming language: ");
            String language = reader.readLine();

            writer.write("Name: " + name + "\n");
            writer.write("Age: " + age + "\n");
            writer.write("Favorite Language: " + language + "\n");

            System.out.println("Information saved to " + outputFile);

        } catch (IOException e) {
            System.err.println("An error occurred:");
            e.printStackTrace();
        }
    }
}
