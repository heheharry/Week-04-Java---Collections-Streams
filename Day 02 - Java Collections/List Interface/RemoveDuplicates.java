package Day2.ListInterface;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
public class RemoveDuplicates {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(3); list.add(1); list.add(2); list.add(2); list.add(3); list.add(4);

        Set<Integer> seen = new LinkedHashSet<>(list);
        List<Integer> result = new ArrayList<>(seen);

        System.out.println("List without duplicates: " + result);
    }
}
