package Day1;
import java.io.*;
import java.nio.file.Files;
import java.util.Arrays;
public class ImageByteArrayConvertor {
    public static void main(String[] args) {
        String originalImage = "original.jpg";
        String copiedImage = "copy.jpg";

        try {
            byte[] imageBytes = Files.readAllBytes(new File(originalImage).toPath());

            ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            int byteData;
            while ((byteData = bais.read()) != -1) {
                baos.write(byteData);
            }

            byte[] copiedBytes = baos.toByteArray();
            Files.write(new File(copiedImage).toPath(), copiedBytes);

            if (Arrays.equals(imageBytes, copiedBytes)) {
                System.out.println("Image copied successfully and byte arrays match.");
            } else {
                System.out.println("Image copy failed. Byte arrays do not match.");
            }

        } catch (IOException e) {
            System.err.println("An error occurred:");
            e.printStackTrace();
        }
    }
}
