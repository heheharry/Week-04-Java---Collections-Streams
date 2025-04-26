package Day2.ListInterface;
import java.util.LinkedList;
import java.util.ListIterator;
public class NthFromEnd {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("A"); list.add("B"); list.add("C"); list.add("D"); list.add("E");

        int n = 2;
        ListIterator<String> first = list.listIterator();
        ListIterator<String> second = list.listIterator();

        for (int i = 0; i < n; i++) {
            if (first.hasNext()) {
                first.next();
            } else {
                System.out.println("N is larger than the list size");
                return;
            }
        }

        while (first.hasNext()) {
            first.next();
            second.next();
        }

        if (second.hasNext()) {
            System.out.println("Nth element from end: " + second.next());
        }
    }
}
