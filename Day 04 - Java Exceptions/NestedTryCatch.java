package Day2;
import java.util.Scanner;
public class NestedTryCatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the size of the array:");
        int size = scanner.nextInt();
        int[] array = new int[size];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println("Enter the index to access:");
        int index = scanner.nextInt();

        System.out.println("Enter the divisor:");
        int divisor = scanner.nextInt();

        try {
            try {
                int element = array[index];
                int result = element / divisor;
                System.out.println("Result: " + result);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid array index!");
            } catch (ArithmeticException e) {
                System.out.println("Cannot divide by zero!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
