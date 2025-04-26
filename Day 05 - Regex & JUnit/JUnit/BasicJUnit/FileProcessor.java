package Day3.JUnit.BasicJUnit;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
public class FileProcessor {
    public static void writeToFile(String filename, String content) throws IOException {
        Path path = Paths.get(filename);
        Files.writeString(path, content);
    }

    public static String readFromFile(String filename) throws IOException {
        Path path = Paths.get(filename);
        return Files.readString(path);
    }
}

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class FileProcessorTest {

    private final String testFilename = "testfile.txt";

    @AfterEach
    void cleanUp() throws IOException {
        Path path = Paths.get(testFilename);
        if (Files.exists(path)) {
            Files.delete(path);
        }
    }

    @Test
    void testWriteAndReadFile() throws IOException {
        String content = "Hello, World!";
        FileProcessor.writeToFile(testFilename, content);

        assertTrue(Files.exists(Paths.get(testFilename)), "File should exist after writing.");

        String readContent = FileProcessor.readFromFile(testFilename);
        assertEquals(content, readContent, "File content should match written content.");
    }

    @Test
    void testReadNonExistingFileThrowsException() {
        String nonExistingFile = "non_existing_file.txt";
        assertThrows(IOException.class, () -> FileProcessor.readFromFile(nonExistingFile),
                "Reading a non-existing file should throw IOException");
    }
}