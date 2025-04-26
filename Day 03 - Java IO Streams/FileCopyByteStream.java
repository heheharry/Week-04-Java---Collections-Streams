package Day1;
import java.io.*;
public class FileCopyByteStream {
    public static void main(String[] args) {
        String sourceFile = "C:\\Users\\sreeh\\Downloads\\Capgemini Training\\Java\\Java Training_Bridge Labs_Week-4\\src\\Day4\\FileReader\\example.txt";
        String destinationFile = "destination.txt";

        File inputFile = new File(sourceFile);

        if (!inputFile.exists()) {
            System.out.println("Source file '" + sourceFile + "' does not exist.");
            return;
        }

        try (FileInputStream fis = new FileInputStream(inputFile);
             FileOutputStream fos = new FileOutputStream(destinationFile)) {

            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            System.out.println("File copied successfully from '" + sourceFile + "' to '" + destinationFile + "'.");

        } catch (IOException e) {
            System.err.println("An error occurred during file operations:");
            e.printStackTrace();
        }
    }
}
