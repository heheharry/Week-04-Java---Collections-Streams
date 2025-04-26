package Day5.ProblemStatements;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalHandling {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 9, 2, 8, 1);
        Optional<Integer> max = numbers.stream().max(Integer::compareTo);
        System.out.println(max.orElse(-1));
    }
}
