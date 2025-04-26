package Day5.ProblemStatements;
@FunctionalInterface
interface Square {
    int calculate(int x);
    default void printResult(int x) {
        System.out.println("Square: " + calculate(x));
    }
}

public class CustomFunctionalInterfaceExample {
    public static void main(String[] args) {
        Square square = n -> n * n;
        square.printResult(5);
    }
}
