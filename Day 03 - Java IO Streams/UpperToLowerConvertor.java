package Day1;
import java.io.*;
public class UpperToLowerConvertor {
    public static void main(String[] args) {
        String inputFile = "user_info.txt";
        String outputFile = "output.txt";

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile), "UTF-8"));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile), "UTF-8"))) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line.toLowerCase());
                writer.newLine();
            }

            System.out.println("Conversion complete. Output saved to " + outputFile);

        } catch (IOException e) {
            System.err.println("An error occurred:");
            e.printStackTrace();
        }
    }
}
