package Day2;
import java.util.Scanner;
public class MultipleCatchBlocks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer[] numbers = {10, 20, 30, 40, 50};

        try {
            System.out.print("Enter index to access: ");
            int index = scanner.nextInt();
            System.out.println("Value at index " + index + ": " + numbers[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index!");
        } catch (NullPointerException e) {
            System.out.println("Array is not initialized!");
        } catch (Exception e) {
            System.out.println("Unexpected error occurred.");
        } finally {
            scanner.close();
        }
    }
}
