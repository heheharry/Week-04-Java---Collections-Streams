package Day2.MapInterface;
import java.io.*;
import java.util.*;
public class WordFrequencyCounter {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\sreeh\\Downloads\\Capgemini Training\\Java\\Java Training_Bridge Labs_Week-4\\src\\Day4\\FileReader\\example.txt";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            Map<String, Integer> wordCount = new HashMap<>();

            while ((line = reader.readLine()) != null) {
                String[] words = line.split("[^a-zA-Z]+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        word = word.toLowerCase();
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    }
                }
            }
            reader.close();

            System.out.println(wordCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
