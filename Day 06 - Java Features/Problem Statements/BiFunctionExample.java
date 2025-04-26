package Day5.ProblemStatements;
import java.util.function.BiFunction;

public class BiFunctionExample {
    public static void main(String[] args) {
        BiFunction<String, String, String> concatenate = (s1, s2) -> s1 + " " + s2;
        System.out.println(concatenate.apply("Hello", "World"));
    }
}
