package Day2.ListInterface;
import java.util.LinkedList;
public class ReverseArrayListUsingLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1); list.add(2); list.add(3); list.add(4); list.add(5);
        int left = 0, right = list.size() - 1;
        while (left < right) {
            Integer temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
            left++;
            right--;
        }

        System.out.println("Reversed LinkedList: " + list);
    }
}
