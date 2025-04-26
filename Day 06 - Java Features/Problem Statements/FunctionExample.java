package Day5.ProblemStatements;
import java.util.function.Function;

public class FunctionExample {
    public static void main(String[] args) {
        Function<Double, Double> area = r -> Math.PI * r * r;
        System.out.println(area.apply(5.0));
    }
}
