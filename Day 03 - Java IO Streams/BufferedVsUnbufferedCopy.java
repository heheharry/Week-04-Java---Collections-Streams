package Day1;
import java.io.*;
public class BufferedVsUnbufferedCopy {
    public static void main(String[] args) {
        String sourceFile = "C:\\Users\\sreeh\\Downloads\\Capgemini Training\\Java\\Java Training_Bridge Labs_Week-4\\src\\Day4\\FileReader\\example.txt";
        String bufferedDest = "buffered_copy.dat";
        String unbufferedDest = "unbuffered_copy.dat";

        long bufferedTime = copyWithBufferedStream(sourceFile, bufferedDest);
        long unbufferedTime = copyWithUnbufferedStream(sourceFile, unbufferedDest);

        System.out.println("Buffered copy time: " + bufferedTime + " ns");
        System.out.println("Unbuffered copy time: " + unbufferedTime + " ns");
    }

    private static long copyWithBufferedStream(String source, String destination) {
        long startTime = System.nanoTime();

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destination))) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return System.nanoTime() - startTime;
    }

    private static long copyWithUnbufferedStream(String source, String destination) {
        long startTime = System.nanoTime();

        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(destination)) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return System.nanoTime() - startTime;
    }
}
