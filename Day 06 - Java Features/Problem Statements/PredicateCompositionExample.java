package Day5.ProblemStatements;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateCompositionExample {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Hello", "World", "JavaProgramming", "Predicate", "Lambda");
        Predicate<String> lengthGreaterThanFive = s -> s.length() > 5;
        Predicate<String> containsJava = s -> s.contains("Java");
        List<String> filteredWords = words.stream()
                .filter(lengthGreaterThanFive.and(containsJava))
                .collect(Collectors.toList());
        System.out.println(filteredWords);
    }
}
