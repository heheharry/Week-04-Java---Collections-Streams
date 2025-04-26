package Day3.JUnit.BasicJUnit;
import java.util.List;
public class ListManager {
    public static void addElement(List<Integer> list, int element) {
        if (list != null) {
            list.add(element);
        }
    }

    public static void removeElement(List<Integer> list, int element) {
        if (list != null) {
            list.remove(Integer.valueOf(element)); // important: remove by value, not index
        }
    }

    public static int getSize(List<Integer> list) {
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
        import java.util.ArrayList;
import java.util.List;

class ListManagerTest {

    @Test
    void testAddElement() {
        List<Integer> list = new ArrayList<>();
        ListManager.addElement(list, 10);
        assertEquals(1, list.size());
        assertTrue(list.contains(10));
    }

    @Test
    void testRemoveElement() {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(10);
        ListManager.removeElement(list, 5);
        assertEquals(1, list.size());
        assertFalse(list.contains(5));
    }

    @Test
    void testGetSize() {
        List<Integer> list = new ArrayList<>();
        assertEquals(0, ListManager.getSize(list));

        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(3, ListManager.getSize(list));
    }

    @Test
    void testNullList() {
        assertEquals(0, ListManager.getSize(null));

        // addElement and removeElement should not throw exception with null
        ListManager.addElement(null, 5);
        ListManager.removeElement(null, 5);
    }
}