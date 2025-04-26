package Day2.ListInterface;
import java.util.ArrayList;
import java.util.List;
public class RotateList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(10); list.add(20); list.add(30); list.add(40); list.add(50);

        int k = 2;
        int size = list.size();
        List<Integer> rotated = new ArrayList<>();

        for (int i = k; i < size; i++) {
            rotated.add(list.get(i));
        }
        for (int i = 0; i < k; i++) {
            rotated.add(list.get(i));
        }

        System.out.println("Rotated List: " + rotated);
    }
}
