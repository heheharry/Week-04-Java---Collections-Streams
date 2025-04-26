package Day1;
import java.io.*;
public class ReadLargeFileWithError {
    public static void main(String[] args) {
        String filename = "largefile.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.toLowerCase().contains("error")) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file:");
            e.printStackTrace();
        }
    }
}
