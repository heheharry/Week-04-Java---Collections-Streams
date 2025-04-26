package Day1;
import java.io.*;
public class PipedStreamCommunication {
    public static void main(String[] args) {
        try {
            PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream pis = new PipedInputStream(pos);

            Thread writerThread = new Thread(() -> {
                try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(pos))) {
                    writer.write("Message from writer thread.");
                    writer.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            Thread readerThread = new Thread(() -> {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(pis))) {
                    String message = reader.readLine();
                    System.out.println("Reader received: " + message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            readerThread.start();
            writerThread.start();

            writerThread.join();
            readerThread.join();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
