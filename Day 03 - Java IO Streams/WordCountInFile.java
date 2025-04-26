package Day1;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
public class WordCountInFile {
    public static void main(String[] args) {
        String filename = "largefile.txt";

        HashMap<String, Integer> wordCountMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\W+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        word = word.toLowerCase();
                        wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                    }
                }
            }

            List<Map.Entry<String, Integer>> topWords = wordCountMap.entrySet()
                    .stream()
                    .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                    .limit(5)
                    .collect(Collectors.toList());

            for (Map.Entry<String, Integer> entry : topWords) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
