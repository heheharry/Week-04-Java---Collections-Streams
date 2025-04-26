package Day2.ListInterface;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class FrequencyCounter {
    public static void main(String[] args) {
        List<String> items = new ArrayList<>();
        items.add("apple");
        items.add("banana");
        items.add("apple");
        items.add("orange");

        Map<String, Integer> frequencyMap = new HashMap<>();

        for (String item : items) {
            if (frequencyMap.containsKey(item)) {
                frequencyMap.put(item, frequencyMap.get(item) + 1);
            } else {
                frequencyMap.put(item, 1);
            }
        }

        System.out.println("Frequency Map: " + frequencyMap);
    }
}
